package ru.iukhimenko.play.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.iukhimenko.play.pages.StartPage;

import static ru.iukhimenko.play.core.ProjectConfiguration.CONFIGURATION;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseUITest {
    @BeforeAll
    public void setUp() {
        Configuration.baseUrl = CONFIGURATION.baseUrl();
        Selenide.open("/");
        Selenide.webdriver().object().manage().window().maximize();
        new StartPage().acceptAllCookies();
    }
}
