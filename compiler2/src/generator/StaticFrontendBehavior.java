package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creates the browser-only behavior bundled with the static output. All add,
 * select and delete operations happen in the open page; no source file changes.
 */
public final class StaticFrontendBehavior {
    private StaticFrontendBehavior() {
    }

    public static String generate(Map<String, Object> context) {
        Object products = context == null ? List.of() : context.get("products");
        String initialProducts = toJson(products instanceof List<?> ? products : List.of());

        return """
                (() => {
                  "use strict";

                  const seededProducts = %s;
                  const listElement = document.querySelector(".product-list ul");
                  const detailsElement = document.querySelector(".product-details");
                  const addForm = document.querySelector("#add-product-form");
                  // The generated source is authoritative on each page load. Browser
                  // edits exist for this open page only and never overwrite source data.
                  let products = seededProducts.map((product) => ({ ...product }));
                  let selectedProductId = null;

                  function escapeHtml(value) {
                    return String(value ?? "")
                      .replaceAll("&", "&amp;")
                      .replaceAll("<", "&lt;")
                      .replaceAll(">", "&gt;")
                      .replaceAll('"', "&quot;")
                      .replaceAll("'", "&#39;");
                  }

                  function productId(product) {
                    return String(product.id);
                  }

                  function renderProducts() {
                    if (!listElement) return;
                    listElement.innerHTML = products.map((product) => `
                      <li class="product-item" data-product-id="${escapeHtml(productId(product))}" tabindex="0" role="button">
                        <img src="${escapeHtml(product.image || "https://picsum.photos/id/100/200/200")}" alt="${escapeHtml(product.name)}">
                        <span>${escapeHtml(product.name)}</span>
                      </li>`).join("");

                    if (selectedProductId !== null && !products.some((item) => productId(item) === selectedProductId)) {
                      selectedProductId = null;
                    }
                    renderDetails();
                  }

                  function renderDetails() {
                    if (!detailsElement) return;
                    const product = products.find((item) => productId(item) === selectedProductId);
                    if (!product) {
                      detailsElement.innerHTML = `
                        <div class="empty-state">
                          <div class="empty-icon">&#9783;</div>
                          <p>Select a product to see details</p>
                        </div>`;
                      return;
                    }

                    detailsElement.innerHTML = `
                      <h3>${escapeHtml(product.name)}</h3>
                      <img src="${escapeHtml(product.image || "https://picsum.photos/id/100/200/200")}" alt="${escapeHtml(product.name)}">
                      <div class="detail-row">
                        <span class="detail-label">Details</span>
                        <span class="detail-value">${escapeHtml(product.details)}</span>
                      </div>
                      <div class="detail-row">
                        <span class="detail-label">Price</span>
                        <span class="detail-value">$${escapeHtml(product.price)}</span>
                      </div>
                      <button type="button" class="btn-delete" id="delete-product-button">Delete Product</button>`;

                    const deleteButton = document.querySelector("#delete-product-button");
                    if (deleteButton) {
                      deleteButton.addEventListener("click", () => {
                        products = products.filter((item) => productId(item) !== selectedProductId);
                        selectedProductId = null;
                        renderProducts();
                      });
                    }
                  }

                  function selectProduct(id) {
                    selectedProductId = String(id);
                    renderDetails();
                  }

                  if (listElement) {
                    listElement.addEventListener("click", (event) => {
                      const item = event.target.closest(".product-item");
                      if (item) selectProduct(item.dataset.productId);
                    });
                    listElement.addEventListener("keydown", (event) => {
                      if (event.key !== "Enter" && event.key !== " ") return;
                      const item = event.target.closest(".product-item");
                      if (!item) return;
                      event.preventDefault();
                      selectProduct(item.dataset.productId);
                    });
                  }

                  if (addForm) {
                    addForm.addEventListener("submit", (event) => {
                      event.preventDefault();
                      const name = addForm.elements.name.value.trim();
                      const details = addForm.elements.details.value.trim();
                      const priceText = addForm.elements.price.value.trim();
                      const price = Number(priceText);
                      const image = addForm.elements.image.value.trim() || "https://picsum.photos/id/100/200/200";

                      if (!name || !details || !priceText || !Number.isFinite(price)) {
                        window.alert("Please enter a name, details and a valid price.");
                        return;
                      }

                      const nextId = products.reduce((maxId, product) => {
                        const id = Number(product.id);
                        return Number.isFinite(id) ? Math.max(maxId, id) : maxId;
                      }, 0) + 1;
                      const product = { id: nextId, name, details, price, image };
                      products.push(product);
                      selectedProductId = productId(product);
                      addForm.reset();
                      renderProducts();
                    });
                  }

                  renderProducts();
                })();
                """.formatted(initialProducts);
    }

    private static String toJson(Object value) {
        if (value == null) return "null";
        if (value instanceof String text) return "\"" + escapeJson(text) + "\"";
        if (value instanceof Number || value instanceof Boolean) return String.valueOf(value);
        if (value instanceof List<?> list) {
            List<String> items = new ArrayList<>();
            for (Object item : list) items.add(toJson(item));
            return "[" + String.join(",", items) + "]";
        }
        if (value instanceof Map<?, ?> map) {
            List<String> entries = new ArrayList<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                entries.add(toJson(String.valueOf(entry.getKey())) + ":" + toJson(entry.getValue()));
            }
            return "{" + String.join(",", entries) + "}";
        }
        return toJson(String.valueOf(value));
    }

    private static String escapeJson(String value) {
        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
