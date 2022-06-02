package ru.iukhimenko.play.pages;

import ru.iukhimenko.play.elements.NavigationMenu;
import ru.iukhimenko.play.pages.catalog.ForBabysCatalogPage;

import static ru.iukhimenko.play.enums.NavigationMenuItem.FOR_BABYS;

public abstract class BasePage {
    protected final NavigationMenu navigationMenu;

    public BasePage() {
        navigationMenu = new NavigationMenu();
    }


    public ForBabysCatalogPage openForBabysCatalog() {
        navigationMenu.openMenuItem(FOR_BABYS);
        return new ForBabysCatalogPage();
    }
}
