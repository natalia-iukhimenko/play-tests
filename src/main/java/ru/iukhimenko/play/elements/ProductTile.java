package ru.iukhimenko.play.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductTile {
    private final SelenideElement detailsLink;
    private final SelenideElement imageElement;
    private final SelenideElement quickViewElement;
    private final SelenideElement nameElement;
    private final SelenideElement priceElement;
    private final SelenideElement stockStatus;

    public ProductQuickViewForm openQuickViewForm() {
        imageElement.hover();
        quickViewElement.shouldBe(Condition.visible)
                .click();
        return new ProductQuickViewForm();
    }
}
