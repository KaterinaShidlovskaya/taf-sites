package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BookingTest {
    ChromeDriver driver;
    BookingPage bookingPage = new BookingPage();

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/");

        WebElement buttonRegister = (new WebDriverWait(driver, Duration.ofSeconds(10))).
                until(ExpectedConditions.elementToBeClickable(By.xpath(bookingPage.buttonRegisterXpath)));
        buttonRegister.click();
    }

    @Test
    public void testLoginWithEmptyEmailAddress() {
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();

        String actualMessageXpath = "//*[@id='username-note']";
        WebElement actualMessageWebElement = driver.findElement(By.xpath(actualMessageXpath));
        String actualMessage = actualMessageWebElement.getText();

        String expectedMessage = "Введите электронный адрес";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithIncorrectEmailAddress() {
        WebElement inputEmailAddress = driver.findElement(By.xpath(bookingPage.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("email");

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();

        String expectedMessage = "Проверьте правильность ввода.";

        WebElement actualMessageXpath = driver.findElement(By.xpath("//*[@id='username-note']"));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAddress() {
        WebElement inputEmailAddress = driver.findElement(By.xpath(bookingPage.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@mail.com");

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();

        String expectedMessage = "Введите пароль от аккаунта Booking.com для test@mail.com.";

        WebElement actualMessageXpath = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='nw-step-description']"))));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword() {
        WebElement inputEmailAddress = driver.findElement(By.xpath(bookingPage.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@mail.com");

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();

        WebElement buttonSingIn = (new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(bookingPage.buttonSingInXpath))));
        buttonSingIn.click();

        String expectedMessage = "Enter your Booking.com password";

        WebElement actualMessageXpath = driver.findElement(By.xpath("//*[@id='password-note']"));
        String actualMessage = actualMessageXpath.getText();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginWithCorrectEmailAndPassword() {
        WebElement inputEmailAddress = driver.findElement(By.xpath(bookingPage.inputEmailAddressXpath));
        inputEmailAddress.sendKeys("test@mail.com");

        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(bookingPage.buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();

        WebElement inputPassword = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(bookingPage.inputPasswordXpath))));
        inputPassword.sendKeys("12345");

        WebElement buttonSingIn = driver.findElement(By.xpath(bookingPage.buttonSingInXpath));
        buttonSingIn.click();
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
