package ru.iukhimenko.play.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartPage extends BasePage {
    private final ElementsCollection productRows = $$(By.xpath("//li[contains(@id, 'productItem_')]"));
    private final SelenideElement alertInfoElement = $(By.cssSelector(".alert-info"));

    private List<ProductRow> getProductRows() {
        List<ProductRow> rows = new ArrayList<>();
        productRows.asFixedIterable().forEach(el -> {
            SelenideElement nameElement = el.find(By.className("name"));
            SelenideElement removeButton = el.find((By.className("remove-item-btn")));
            rows.add(new ProductRow(nameElement, removeButton));
        });
        return rows;
    }

    public ShoppingCartPage checkAllProductsRemoval() {
        getProductRows().forEach(row -> {
            row.remove();
            checkProductRemovedMessage();
            boolean isRowRemoved = getProductRows().stream()
                    .noneMatch(r -> r.getProductName().equals(row.getProductName()));
            assertThat(isRowRemoved).isTrue();
        });
        checkCartEmptyMessageDisplayed();
        return this;
    }

    private ShoppingCartPage checkCartEmptyMessageDisplayed() {
        String actualText = $(By.tagName("h1")).getText();
        assertThat(actualText.trim()).isEqualTo("Your shopping cart is empty!");
        return this;
    }

    private ShoppingCartPage checkAlertInfo(String expectedMessage) {
        alertInfoElement.should(exist);
        assertThat(alertInfoElement.getText()).containsOnlyOnce(expectedMessage);
        return this;
    }

    private ShoppingCartPage checkProductRemovedMessage() {
        return checkAlertInfo("Product has been removed from your cart");
    }

    @AllArgsConstructor
    public static class ProductRow {
        private final SelenideElement nameElement;
        private final SelenideElement removeButton;

        public void remove() {
            removeButton.click();
        }

        public String getProductName() {
            return nameElement.getText();
        }
    }
}


