package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosPage {
    private ChromeDriver driver;
    private String buttonLoginXpath = "//*[@id='b2indexPage']/div[22]/div/div/div/div[2]/div/a";
    private String buttonPopUpCloseXpath = "/html/body/div[3]/div[2]/button";
    private String inputEmailAddressXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/div[1]/input";
    private String inputPasswordXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/div[2]/input";
    private String buttonSingInXpath = "/html/body/div[4]/div[2]/div/div/div/div[2]/div[2]/div/form/div/button";
    private String baseURL = "https://dominos.by/";

    public DominosPage(ChromeDriver newDriver) {
        driver = newDriver;
    }
    public void openBaseURL(){
        driver.get(baseURL);
    }

    public void clickButtonLogin(){
        WebElement buttonLogin = driver.findElement(By.xpath(buttonLoginXpath));
        buttonLogin.click();
    }

    public void clickButtonPopUpClose(){
        WebElement buttonPopUpClose = driver.findElement(By.xpath(buttonPopUpCloseXpath));
        buttonPopUpClose.click();
    }

    public void sendKeysInputEmailAddress(String email){
        WebElement inputEmail = driver.findElement(By.xpath(inputEmailAddressXpath));
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String password){
        WebElement inputPassword = driver.findElement(By.xpath(inputPasswordXpath));
        inputPassword.sendKeys(password);
    }

    public void clickButtonSingIn(){
        WebElement buttonSingIn = driver.findElement(By.xpath(buttonSingInXpath));
        buttonSingIn.click();
    }


}
