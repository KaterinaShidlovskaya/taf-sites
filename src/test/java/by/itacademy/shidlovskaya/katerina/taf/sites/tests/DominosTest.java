package by.itacademy.shidlovskaya.katerina.taf.sites.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import by.itacademy.shidlovskaya.katerina.taf.sites.steps.DominosStep;
import by.itacademy.shidlovskaya.katerina.taf.sites.utils.Util;


public class DominosTest {
    ChromeDriver driver;
    DominosStep dominosStep;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        dominosStep = new DominosStep(driver);
        driver.manage().window().maximize();
        dominosStep.openURLAndClickButtonLogin();
    }

    @Test
    public void testLoginWithIncorrectEmailAndSomePassword() {
       dominosStep.fillLoginFormWithInvalidEmailAndSomePassword(Util.generateInvalidEmail(),Util.generatePassword());
    }

    @Test
    public void testLoginWithAnyEmailAndPassword() {
        dominosStep.fillLoginFormWithAnyEmailAndPassword(Util.generateEmail(),Util.generatePassword());
        String actualErrorMessage = dominosStep.getActualErrorMessage();
        Assertions.assertEquals(actualErrorMessage, "Неверный логин или пароль");
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}