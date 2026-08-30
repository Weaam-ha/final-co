import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

/** Watches the two compiler inputs only when Main is launched with --watch. */
public final class WatchService {
    private static final Path WATCH_DIRECTORY = Paths.get("compiler2");

    private WatchService() {
    }

    public static void start() throws IOException {
        if (!Files.isDirectory(WATCH_DIRECTORY)) {
            System.out.println("Watch directory not found: " + WATCH_DIRECTORY);
            return;
        }

        try (java.nio.file.WatchService watcher = FileSystems.getDefault().newWatchService()) {
            WATCH_DIRECTORY.register(
                    watcher,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE
            );

            System.out.println();
            System.out.println("=================================");
            System.out.println("        WATCH SERVICE STARTED     ");
            System.out.println("=================================");
            System.out.println("Watching only: flask_app.txt and front_test.txt");
            System.out.println("Press Ctrl+C to stop.");
            System.out.println();

            while (!Thread.currentThread().isInterrupted()) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    break;
                }

                boolean shouldRun = false;
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    Path changedFile = (Path) event.context();
                    String name = changedFile.getFileName().toString();
                    if (name.equals("flask_app.txt") || name.equals("front_test.txt")) {
                        System.out.println("Source change detected: " + event.kind().name() + " -> " + name);
                        shouldRun = true;
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    System.out.println("Watch directory is no longer available; stopping watch mode.");
                    break;
                }

                if (!shouldRun) {
                    continue;
                }

                // Editors commonly emit several save events. A brief delay groups
                // them into one deterministic regeneration without starting a new JVM.
                try {
                    Thread.sleep(250);
                } catch (InterruptedException interrupted) {
                    Thread.currentThread().interrupt();
                    break;
                }

                System.out.println("\nRecompiling changed source files...");
                try {
                    Main.compileOnce();
                } catch (Exception error) {
                    System.err.println("Compilation error: " + error.getMessage());
                    error.printStackTrace();
                }
                System.out.println("Waiting for the next source change...\n");
            }
        }

        System.out.println("Watch service stopped.");
    }
}
