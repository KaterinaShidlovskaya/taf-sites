package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {

    private ChromeDriver driver;

    private String buttonLoginXpath = "//*[@id='b2indexPage']/div[22]/div/div/div/div[2]/div/a";
    private String inputEmailAddressXpath = "//*[@id='username']";
    private String buttonContinueWithEmailXpath = "//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[3]/button";
    private String inputPasswordXpath = "//*[@id='password']";
    private String buttonSingInXpath = "//*[@id='root']/div/div/div/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/button";
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
        WebElement inputEmailAddress = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmailAddress.sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPassword = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(inputPasswordXpath))));
        inputPassword.sendKeys(password);
    }

    public void clickButtonSingIn() {
        WebElement buttonSingIn = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(buttonSingInXpath))));
        buttonSingIn.click();
    }
}
