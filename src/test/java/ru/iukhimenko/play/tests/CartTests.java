package ru.iukhimenko.play.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.iukhimenko.play.core.BaseUITest;
import ru.iukhimenko.play.pages.StartPage;

public class CartTests extends BaseUITest {
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void checkClearingTheCart(int productsCount) {
        new StartPage().acceptAllCookies()
                .openForBabysCatalog()
                .addAvailableProductToCart(productsCount)
                .goToCart()
                .checkAllProductsRemoval();
    }
}
