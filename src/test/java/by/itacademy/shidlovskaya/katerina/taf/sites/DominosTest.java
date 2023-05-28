package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class DominosTest {
    ChromeDriver driver;
    DominosStep dominosStep;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        dominosStep = new DominosStep(driver);
        dominosStep.openURLAndClickButtonLogin();
    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
       dominosStep.fillLoginFormWithInvalidEmailAndAnyPassword(Util.generateInvalidEmail(),Util.generatePassword());
    }

    @Test
    public void testLoginWithAnyEmailAndPassword() {
        dominosStep.fillLoginFormWithAnyEmailAndPassword(Util.generateEmail(),Util.generatePassword());
    }

    @AfterEach
    public void tearsDown() {
        dominosStep.finishTheWork();
    }
}