package by.itacademy.shidlovskaya.katerina.taf.sites.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import by.itacademy.shidlovskaya.katerina.taf.sites.steps.PizzatempoStep;
import by.itacademy.shidlovskaya.katerina.taf.sites.utils.Util;

public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoStep pizzatempoStep;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        pizzatempoStep = new PizzatempoStep(driver);
        driver.manage().window().maximize();
        pizzatempoStep.getURLAndMaximizeWindowInChrome();
    }

    @Test
    public void testLoginWithEmptyData() {
        pizzatempoStep.fillLoginFormWithEmptyData();
    }

    @Test
    public void testLoginWithIncorrectEmail() {
        pizzatempoStep.fillLoginFormWithIncorrectEmailAndSubmit(Util.generateInvalidEmail());
    }

    @Test
    public void testLoginWithSomePassword() {
        pizzatempoStep.fillLoginFormWithSomePassword(Util.generatePassword());
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateEmail(), "");
    }

    @Test
    public void testLoginWithCorrectEmailAndSomePassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePassword());
        String actualText = pizzatempoStep.getActualErrorMessage();
        Assertions.assertEquals(actualText, "Неверно указано имя пользователя или пароль.\n"+"Ok");
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}