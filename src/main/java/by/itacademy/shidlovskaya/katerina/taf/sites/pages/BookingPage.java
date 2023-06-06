package by.itacademy.shidlovskaya.katerina.taf.sites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {

    private ChromeDriver driver;

    private String buttonLoginXpath = "//a[@ class='fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 c938084447 f4605622ad']";
    private String inputEmailAddressName = "username";
    private String buttonContinueWithEmailXpath = "//button[@type='submit']";
    private String inputNewPasswordName = "new_password";
    private String inputConfirmedPasswordName = "confirmed_password";
    private String buttonSingInXpath = "//button[@type='submit']";
    private String baseURL = "https://www.booking.com/";

    public BookingPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void clickButtonRegister() {
        WebElement buttonRegister = (new WebDriverWait(driver, Duration.ofSeconds(10))).
                until(ExpectedConditions.elementToBeClickable(By.xpath(buttonLoginXpath)));
        buttonRegister.click();
    }

    public void clickButtonContinueWithEmail() {
        WebElement buttonContinueWithEmail = driver.findElement(By.xpath(buttonContinueWithEmailXpath));
        buttonContinueWithEmail.click();
    }

    public void sendKeysInputEmailAddress(String email) {
        WebElement inputEmailAddress = driver.findElement(By.name(inputEmailAddressName));
        inputEmailAddress.sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPassword = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.name(inputNewPasswordName))));
        inputPassword.sendKeys(password);
    }

    public void clickButtonSingIn() {
        WebElement buttonSingIn = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(buttonSingInXpath))));
        buttonSingIn.click();
    }
}
