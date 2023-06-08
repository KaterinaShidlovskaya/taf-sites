package by.itacademy.shidlovskaya.katerina.taf.sites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosPage {
    private ChromeDriver driver;
    private String buttonLoginXpath = "//button[@type='button']";
    private String buttonPopUpCloseXpath = "/html/body/div[3]/div[2]/button";
    private String inputEmailAddressName = "email";
    private String inputPasswordName = "password";
    private String buttonSingInXpath = "//button[@type='submit']";
    private String baseURL = "https://dominos.by/";
    private String textErrorMessage = "/html/body/div[4]/div[2]/div[1]/div/div[2]";

    public DominosPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public DominosPage openBaseURL() {
        driver.get(baseURL);
        return this;
    }

    public DominosPage clickButtonLogin() {
        WebElement buttonLogin = driver.findElement(By.xpath(buttonLoginXpath));
        buttonLogin.click();
        return this;
    }

    public DominosPage clickButtonPopUpClose() {
        WebElement buttonPopUpClose = driver.findElement(By.xpath(buttonPopUpCloseXpath));
        buttonPopUpClose.click();
        return this;
    }

    public DominosPage sendKeysInputEmailAddress(String email) {
        WebElement inputEmail = driver.findElement(By.name(inputEmailAddressName));
        inputEmail.sendKeys(email);
        return this;
    }

    public DominosPage sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name(inputPasswordName));
        inputPassword.sendKeys(password);
        return this;
    }

    public DominosPage clickButtonSingIn() {
        WebElement buttonSingIn = driver.findElement(By.xpath(buttonSingInXpath));
        buttonSingIn.click();
        return this;
    }

    public String getTextErrorMessage(){
        WebElement textErrorMessageElement = driver.findElement(By.xpath(textErrorMessage));
        String actualErrorMessage = textErrorMessageElement.getText();
        return actualErrorMessage;
    }
}