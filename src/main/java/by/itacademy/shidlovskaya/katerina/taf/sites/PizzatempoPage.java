package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoPage {
    private ChromeDriver driver;
    private String inputEmailAddressXpath = "/html/body/div/div[1]/form/p[1]/input";
    private String inputPasswordXpath = "/html/body/div/div[1]/form/p[2]/input[1]";
    private String buttonSearchXpath = "/html/body/div/div[1]/form/p[2]/input[2]";
    private String baseURL = "https://www.pizzatempo.by/";

    public PizzatempoPage(ChromeDriver newDriver) {
        driver = newDriver;
    }

   public void openBaseURL(){
       driver.get(baseURL);
   }
    public void clickButtonSearch() {
        WebElement buttonSearch = driver.findElement(By.xpath(buttonSearchXpath));
        buttonSearch.click();
    }

    public void sendKeysInputEmailAddress(String email) {
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String password){
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordXpath));
        inputPassword.sendKeys(password);
    }
}
