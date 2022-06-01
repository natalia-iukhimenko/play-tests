package ru.iukhimenko.play.pages;

import ru.iukhimenko.play.elements.CookieBannerElement;
import ru.iukhimenko.play.elements.NavigationMenu;

import static ru.iukhimenko.play.enums.NavigationMenuItem.FOR_BABYS;

public class StartPage {
    private final NavigationMenu navigationMenu;
    private final CookieBannerElement cookieBannerElement;

    public StartPage() {
        navigationMenu = new NavigationMenu();
        cookieBannerElement = new CookieBannerElement();
    }

    public StartPage acceptAllCookies() {
        cookieBannerElement.acceptAllCookies();
        return this;
    }

    public void openForBabysCatalog() {
        navigationMenu.openMenuItem(FOR_BABYS);
    }
}
