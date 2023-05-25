package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TripadvisorPage {
    private ChromeDriver driver;
    private String buttonLoginXpath = "//*[@id= 'lithium-root']/header/div/nav/div/div[2]/a[3]";
    private String buttonContinueWithEmailXpath = "//*[@id='ssoButtons']/button";
    private String inputEmailAddressXpath = "//*[@id='regSignIn.email']";
    private String inputPasswordXpath = "//*[@id='regSignIn.password']";
    private String buttonSingInXpath = "//*[@id='regSignIn']/div[4]/button[1]";
    private String baseURL = "https://www.tripadvisor.com/";

    public TripadvisorPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void clickButtonRegister() {
        WebElement buttonRegister = driver.findElement(By.xpath(buttonLoginXpath));
        buttonRegister.click();
    }

    public void clickButtonContinueWithEmail() {
        WebElement buttonContinueWithEmail = (new WebDriverWait(driver, Duration.ofSeconds(20))).
                until(ExpectedConditions.elementToBeClickable(By.xpath(buttonContinueWithEmailXpath)));
        buttonContinueWithEmail.click();
    }

    public void clickButtonSingIn(){
        WebElement buttonSingIn = driver.findElement(By.xpath(buttonSingInXpath));
        buttonSingIn.click();
    }

    public void sendKeysInputEmailAddress(String email){
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String password){
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordXpath));
        inputPassword.sendKeys(password);
    }
}
