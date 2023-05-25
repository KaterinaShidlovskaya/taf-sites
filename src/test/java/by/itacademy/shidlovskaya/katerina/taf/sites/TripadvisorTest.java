package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TripadvisorTest {
    ChromeDriver driver;
    TripadvisorPage tripadvisorPage;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        tripadvisorPage = new TripadvisorPage(driver);
        driver.manage().window().maximize();
        tripadvisorPage.openBaseURL();
        tripadvisorPage.clickButtonRegister();
        tripadvisorPage.clickButtonContinueWithEmail();
    }

    @Test
    public void testRegisterWithEmptyEmailAndPassword() {
        tripadvisorPage.clickButtonSingIn();
    }

    @Test
    public void testLoginWithIncorrectEmail() {
        tripadvisorPage.sendKeysInputEmailAddress("email");
        tripadvisorPage.clickButtonSingIn();
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        tripadvisorPage.sendKeysInputEmailAddress(Util.generateEmail());
        tripadvisorPage.clickButtonSingIn();
    }

    @Test
    public void testLoginWithCorrectEmailAndPassword() {
        tripadvisorPage.sendKeysInputEmailAddress(Util.generateEmail());
        tripadvisorPage.sendKeysInputPassword(Util.generatePassword());
        tripadvisorPage.clickButtonSingIn();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
