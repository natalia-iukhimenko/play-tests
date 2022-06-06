package ru.iukhimenko.play.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.iukhimenko.play.pages.ShoppingCartPage;

import static com.codeborne.selenide.Selenide.$;

public class RightHeaderSlot {
    private final SelenideElement cartButton = $(By.className("mini-cart-link"));
    private final SelenideElement paypalButton = $(By.className("btn-payPalExpress"));

    public ShoppingCartPage openCart() {
        cartButton.click();
        return new ShoppingCartPage();
    }

    public void goDirectlyToPaypal() {
        cartButton.hover();
        paypalButton.shouldBe(Condition.visible);
        paypalButton.click();
    }
}
