package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DominosTest {
    ChromeDriver driver;
    DominosPage dominosPage = new DominosPage();

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        driver.get("https://dominos.by/");

        WebElement buttonPopUpClose = driver.findElement(By.xpath("/html/body/div[3]/div[2]/button"));
        buttonPopUpClose.click();

        WebElement buttonLogin = driver.findElement(By.xpath(dominosPage.buttonLoginXpath));
        buttonLogin.click();


    }

    @Test
    public void testLoginWithIncorrectEmailAndAnyPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(dominosPage.inputEmailAddressXpath));
        inputEmail.sendKeys("email");

        WebElement inputPassword = driver.findElement(By.xpath(dominosPage.inputPasswordXpath));
        inputPassword.sendKeys("12345");

        WebElement buttonSingIn = driver.findElement(By.xpath(dominosPage.buttonSingInXpath));
        buttonSingIn.click();
    }

    @Test
    public void testLoginWithAnyEmailAndPassword() {
        WebElement inputEmail = driver.findElement(By.xpath(dominosPage.inputEmailAddressXpath));
        inputEmail.sendKeys("test@mail.com");

        WebElement inputPassword = driver.findElement(By.xpath(dominosPage.inputPasswordXpath));
        inputPassword.sendKeys("12345");

        WebElement buttonSingIn = driver.findElement(By.xpath(dominosPage.buttonSingInXpath));
        buttonSingIn.click();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
