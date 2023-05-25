package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoTest {
    ChromeDriver driver;
    PizzatempoPage pizzatempoPage;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        pizzatempoPage = new PizzatempoPage(driver);
        driver.manage().window().maximize();
        pizzatempoPage.openBaseURL();
    }

    @Test
    public void testLoginWithEmptyData() {
        pizzatempoPage.clickButtonSearch();
    }

    @Test
    public void testLoginWithIncorrectEmail() {
        pizzatempoPage.sendKeysInputEmailAddress("email");
        pizzatempoPage.clickButtonSearch();
    }

    @Test
    public void testLoginWithAnyPassword() {
        pizzatempoPage.sendKeysInputPassword(Util.generatePassword());
        pizzatempoPage.clickButtonSearch();
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        pizzatempoPage.sendKeysInputEmailAddress(Util.generateEmail());
        pizzatempoPage.clickButtonSearch();
    }

    @Test
    public void testLoginWithCorrectEmailAndAnyPassword() {
        pizzatempoPage.sendKeysInputEmailAddress(Util.generateEmail());
        pizzatempoPage.sendKeysInputPassword(Util.generatePassword());
        pizzatempoPage.clickButtonSearch();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
