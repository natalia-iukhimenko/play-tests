package ru.iukhimenko.play.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class CookieBannerElement {
    private final SelenideElement acceptAllButton = $(By.id("onetrust-accept-btn-handler"));

    public void acceptAllCookies() {
        acceptAllButton.should(exist)
                .click();
        acceptAllButton.shouldNot(exist);
    }
}
