package ru.iukhimenko.play.pages;

import ru.iukhimenko.play.elements.NavigationMenu;

public abstract class BasePage {
    protected final NavigationMenu navigationMenu;

    public BasePage() {
        navigationMenu = new NavigationMenu();
    }
}
