package ru.iukhimenko.play.pages.catalog;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.iukhimenko.play.elements.ProductTile;
import ru.iukhimenko.play.pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public abstract class CatalogPage extends BasePage {
    protected ElementsCollection productTiles = $$x(("//li[contains(@id, 'tile')]"));

    protected List<ProductTile> getProductTiles() {
        List<ProductTile> products = new ArrayList<>();
        productTiles.asFixedIterable().forEach(el -> {
            SelenideElement detailsLink = el.find(By.className("product-tile-link"));
            SelenideElement imageElement = el.find(By.tagName("img"));
            SelenideElement quickViewElement = el.find(By.className("js-shortPds"));
            SelenideElement nameElement = el.find(By.className("details-name"));
            SelenideElement priceElement = el.find(By.className("price"));
            SelenideElement stockStatus = el.find(By.className("product-stockStatus"));
            products.add(new ProductTile(detailsLink, imageElement, quickViewElement, nameElement, priceElement, stockStatus));
        });
        return products;
    }

    protected List<ProductTile> getAvailableProducts() {
        return getProductTiles().stream()
                .filter(p -> p.getStockStatus().attr("class").contains("inStock"))
                .collect(Collectors.toList());
    }

    public void addAvailableProductToCart(int amount) {
        List<ProductTile> productTiles = getAvailableProducts();
        if (!productTiles.isEmpty()) {
            productTiles.get(0).openQuickViewForm()
                    .addToCart(amount);
        } else {
            throw new AssertionError("Failed to add an available product to cart: no available products found");
        }
    }
}
