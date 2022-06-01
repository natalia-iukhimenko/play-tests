package ru.iukhimenko.play.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.iukhimenko.play.enums.NavigationMenuItem;

import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {
    private final SelenideElement forBabysMenuItem = $(By.xpath("//a[contains(@href, 'for-babys--')]"), 0);
    private final SelenideElement woodenToysMenuItem = $(By.xpath("//a[contains(@href, 'wooden-toys--')]"), 0);

    public void openMenuItem(NavigationMenuItem menuItem) {
        switch (menuItem) {
            case FOR_BABYS:
                forBabysMenuItem.click();
                break;
            case WOODEN_TOYS:
                woodenToysMenuItem.click();
                break;
        }
    }
}
