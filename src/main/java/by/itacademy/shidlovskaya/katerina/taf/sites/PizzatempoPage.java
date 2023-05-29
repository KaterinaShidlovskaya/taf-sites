package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailAddressName = "astroauth_login";
    private String inputPasswordName = "astroauth_pass";
    private String buttonSearchName = "astroauth_submit";
    private String baseURL = "https://www.pizzatempo.by/";

    public PizzatempoPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

    public void openBaseURL() {
        driver.get(baseURL);
    }

    public void clickButtonSearch() {
        WebElement buttonSearch = driver.findElement(By.name(buttonSearchName));
        buttonSearch.click();
    }

    public void sendKeysInputEmailAddress(String email) {
        WebElement inputEmail = driver.findElement(By.name(inputEmailAddressName));
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String password) {
        WebElement inputPassword = driver.findElement(By.name(inputPasswordName));
        inputPassword.sendKeys(password);
    }
}