package ru.iukhimenko.play.pages;

import ru.iukhimenko.play.elements.CookieBannerElement;

public class StartPage extends BasePage {
    private final CookieBannerElement cookieBannerElement;

    public StartPage() {
        super();
        cookieBannerElement = new CookieBannerElement();
    }

    public StartPage acceptAllCookies() {
        cookieBannerElement.acceptAllCookies();
        return this;
    }
}
