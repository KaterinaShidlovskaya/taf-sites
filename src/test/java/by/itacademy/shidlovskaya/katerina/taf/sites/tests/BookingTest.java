package by.itacademy.shidlovskaya.katerina.taf.sites.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import by.itacademy.shidlovskaya.katerina.taf.sites.pages.BookingPage;
import by.itacademy.shidlovskaya.katerina.taf.sites.utils.Util;

import java.time.Duration;


public class BookingTest {
    ChromeDriver driver;
    BookingPage bookingPage;

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        bookingPage = new BookingPage(driver);
        driver.manage().window().maximize();
        bookingPage.openBaseURL();
        bookingPage.clickButtonRegister();
    }

    @Test
    public void testLoginWithEmptyEmailAddress() {
        bookingPage.clickButtonContinueWithEmail();

        String actualMessageXpath = "//*[@id='username-note']";
        WebElement actualMessageWebElement = driver.findElement(By.xpath(actualMessageXpath));
        String actualMessage = actualMessageWebElement.getText();

        String expectedMessage = "Введите электронный адрес";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithIncorrectEmailAddress() {
        bookingPage.sendKeysInputEmailAddress("email");
        bookingPage.clickButtonContinueWithEmail();

        String expectedMessage = "Проверьте правильность ввода.";

        WebElement actualMessageXpath = driver.findElement(By.xpath("//*[@id='username-note']"));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAddress() {
        bookingPage.sendKeysInputEmailAddress(Util.generateEmail());
        bookingPage.clickButtonContinueWithEmail();

        String expectedMessage = "Введите пароль от аккаунта Booking.com для test@mail.com.";

        WebElement actualMessageXpath = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='nw-step-description']"))));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        bookingPage.sendKeysInputEmailAddress(Util.generateEmail());
        bookingPage.clickButtonContinueWithEmail();
        bookingPage.clickButtonSingIn();

        String expectedMessage = "Enter your Booking.com password";

        WebElement actualMessageXpath = driver.findElement(By.xpath("//*[@id='password-note']"));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAndPassword() {
        bookingPage.sendKeysInputEmailAddress(Util.generateEmail());
        bookingPage.clickButtonContinueWithEmail();
        bookingPage.sendKeysInputPassword(Util.generatePassword());
        bookingPage.clickButtonSingIn();
        String expectedMessage = "Чтобы подтвердить, что вы человек, нажмите и удерживайте кнопку ниже.";

        WebElement actualMessageXpath = driver.findElement(By.xpath("//div[@class='bui-spacer--largest' and text()='Чтобы подтвердить, что вы человек, нажмите и удерживайте кнопку ниже.']"));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
