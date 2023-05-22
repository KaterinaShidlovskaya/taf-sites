package by.itacademy.shidlovskaya.katerina.taf.sites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PizzatempoTest {
    ChromeDriver driver;
        PizzatempoPage pizzatempoPage =new PizzatempoPage();

        @BeforeEach
        public void warmUp() {
            driver = new ChromeDriver();
            driver.get("https://www.pizzatempo.by/");

        }

        @Test
        public void testLoginWithEmptyData() {
            WebElement buttonSearch = driver.findElement(By.xpath(pizzatempoPage.buttonSearchXpath));
            buttonSearch.click();
        }
        @Test
        public void testLoginWithIncorrectEmail(){
            WebElement inputEmail = driver.findElement(By.xpath(pizzatempoPage.inputEmailAddressXpath));
            inputEmail.sendKeys("email");

            WebElement buttonSearch = driver.findElement(By.xpath(pizzatempoPage.buttonSearchXpath));
            buttonSearch.click();
        }
        @Test
        public void testLoginWithAnyPassword(){
            WebElement inputPassword = driver.findElement(By.xpath(pizzatempoPage.inputPasswordXpath));
            inputPassword.sendKeys("12345");

            WebElement buttonSearch = driver.findElement(By.xpath(pizzatempoPage.buttonSearchXpath));
            buttonSearch.click();
        }
        @Test
        public void testLoginWithCorrectEmailAndEmptyPassword(){
            WebElement inputEmail = driver.findElement(By.xpath(pizzatempoPage.inputEmailAddressXpath));
            inputEmail.sendKeys("test@mail.com");

            WebElement buttonSearch = driver.findElement(By.xpath(pizzatempoPage.buttonSearchXpath));
            buttonSearch.click();
        }
        @Test
        public void testLoginWithCorrectEmailAndAnyPassword(){
            WebElement inputEmail = driver.findElement(By.xpath(pizzatempoPage.inputEmailAddressXpath));
            inputEmail.sendKeys("test@mail.com");

            WebElement inputPassword = driver.findElement(By.xpath(pizzatempoPage.inputPasswordXpath));
            inputPassword.sendKeys("12345");

            WebElement buttonSearch = driver.findElement(By.xpath(pizzatempoPage.buttonSearchXpath));
            buttonSearch.click();
        }
    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
