package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class DominosTest {
    ChromeDriver driver;
    DominosPage dominosPage;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        dominosPage = new DominosPage(driver);
        driver.manage().window().maximize();
        dominosPage.openBaseURL();
        dominosPage.clickButtonPopUpClose();
        dominosPage.clickButtonLogin();
    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
        dominosPage.sendKeysInputEmailAddress("email");
        dominosPage.sendKeysInputPassword(Util.generatePassword());
        dominosPage.clickButtonSingIn();
    }

    @Test
    public void testLoginWithAnyEmailAndPassword() {
        dominosPage.sendKeysInputEmailAddress(Util.generateEmail());
        dominosPage.sendKeysInputPassword(Util.generatePassword());
        dominosPage.clickButtonSingIn();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
