package by.itacademy.shidlovskaya.katerina.taf.sites.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailAddressName = "astroauth_login";
    private String inputPasswordName = "astroauth_pass";
    private String buttonSearchName = "astroauth_submit";
    private String baseURL = "https://www.pizzatempo.by/";
    String actualErrorMessageXPath = "//*[@id=\'alert\']/div[2]/div[2]";

    public PizzatempoPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public PizzatempoPage openBaseURL() {
        driver.get(baseURL);
        return this;
    }

    public PizzatempoPage clickButtonSearch() {
        WebElement buttonSearch = driver.findElement(By.name(buttonSearchName));
        buttonSearch.click();
        return this;
    }

    public PizzatempoPage sendKeysInputEmailAddress(String email) {
        WebElement inputEmail = driver.findElement(By.name(inputEmailAddressName));
        inputEmail.sendKeys(email);
        return this;
    }

    public PizzatempoPage sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name(inputPasswordName));
        inputPassword.sendKeys(password);
        return this;
    }

    public String getTextOfActualErrorMessage() {
        WebElement textOfErrorMessage = driver.findElement(By.xpath(actualErrorMessageXPath));
        return textOfErrorMessage.getText();
    }
}