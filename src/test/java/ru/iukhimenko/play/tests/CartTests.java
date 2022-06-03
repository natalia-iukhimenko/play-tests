package ru.iukhimenko.play.tests;

import org.junit.jupiter.api.Test;
import ru.iukhimenko.play.core.BaseUITest;
import ru.iukhimenko.play.pages.StartPage;

public class CartTests extends BaseUITest {
    @Test
    public void checkClearingTheCart() {
        new StartPage().acceptAllCookies()
                .openForBabysCatalog()
                .addAvailableProductToCart(3)
                .goToCart()
                .checkAllProductsRemoval();
    }
}
