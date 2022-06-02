package ru.iukhimenko.play.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ProductQuickViewForm {
    public final SelenideElement quantitySelector = $(By.id("qtyInput"));
    public final SelenideElement addToCartButton = $(By.id("addToCartButton"));

    public ProductQuickViewForm selectQuantity(int quantity) {
        int minQuantity = 1;
        int maxQuantity = 10;
        if (quantity >= minQuantity && quantity <= maxQuantity) {
            quantitySelector.should(exist);
            quantitySelector.selectOption(String.valueOf(quantity));
        } else {
            throw new AssertionError("Failed to set items quantity = " + quantity + ". Please select a value in range [" + minQuantity + ", " + maxQuantity + "]");
        }
        return this;
    }

    public void addToCart(int quantity) {
        selectQuantity(quantity);
        addToCartButton.click();
        addToCartButton.shouldNot(exist);
    }
}
