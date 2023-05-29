package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void testLoginWithAnyPassword() {
        pizzatempoStep.fillLoginFormWithAnyPassword(Util.generatePassword());
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateEmail(), "");
    }

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        pizzatempoStep.fillLoginFormAndSubmit(Util.generateEmail(), Util.generatePassword());
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}