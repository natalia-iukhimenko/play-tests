package ru.iukhimenko.play.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.iukhimenko.play.core.BaseUITest;
import ru.iukhimenko.play.pages.StartPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTests extends BaseUITest {
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void checkClearingTheCart(int productsCount) {
        new StartPage().openForBabysCatalog()
                .addAvailableProductToCart(productsCount)
                .goToCart()
                .checkAllProductsRemoval();
    }

    @ParameterizedTest
    @ValueSource(strings = "https://www.paypal.com")
    public void checkStartingCheckoutProcess(String expectedUrl) {
        new StartPage().openForBabysCatalog()
                .addAvailableProductToCart(2)
                .goToPaypal();
        assertThat(webdriver().object().getCurrentUrl()).contains(expectedUrl);
    }
}
