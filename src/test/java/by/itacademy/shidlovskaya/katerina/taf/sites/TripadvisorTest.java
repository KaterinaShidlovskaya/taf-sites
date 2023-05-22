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

public class TripadvisorTest {
    ChromeDriver driver;
    TripadvisorPage tripadvisorPage = new TripadvisorPage();

    @BeforeEach
    public void warmUp() {
        driver = new ChromeDriver();
        driver.get("https://www.tripadvisor.com/");
        WebElement buttonRegister = driver.findElement(By.xpath(tripadvisorPage.buttonLoginXpath));
        buttonRegister.click();

        WebElement buttonContinueWithEmail = (new WebDriverWait(driver, Duration.ofSeconds(20))).
                until(ExpectedConditions.elementToBeClickable(By.xpath(tripadvisorPage.buttonContinueWithEmailXpath)));
        buttonContinueWithEmail.click();

    }

    @Test
    public void testRegisterWithEmptyEmailAndPassword() {
     WebElement buttonSingIn = driver.findElement(By.xpath(tripadvisorPage.buttonSingInXpath));
     buttonSingIn.click();
    }
    @Test
    public void testLoginWithIncorrectEmail(){
        WebElement inputEmail =driver.findElement(By.xpath(tripadvisorPage.inputEmailAddressXpath));
        inputEmail.sendKeys("email");

        WebElement buttonSingIn = driver.findElement(By.xpath(tripadvisorPage.buttonSingInXpath));
        buttonSingIn.click();
    }
    @Test
    public void testLoginWithCorrectEmailAndEmptyPassword(){
        WebElement inputEmail =driver.findElement(By.xpath(tripadvisorPage.inputEmailAddressXpath));
        inputEmail.sendKeys("test@mail.com");

        WebElement buttonSingIn = driver.findElement(By.xpath(tripadvisorPage.buttonSingInXpath));
        buttonSingIn.click();
    }
    @Test
    public void testLoginWithCorrectEmailAndPassword(){
        WebElement inputEmail =driver.findElement(By.xpath(tripadvisorPage.inputEmailAddressXpath));
        inputEmail.sendKeys("test@mail.com");

        WebElement inputPassword = driver.findElement(By.xpath(tripadvisorPage.inputPasswordXpath));
        inputPassword.sendKeys("12345");

        WebElement buttonSingIn = driver.findElement(By.xpath(tripadvisorPage.buttonSingInXpath));
        buttonSingIn.click();
    }

    @AfterEach
    public void tearsDown() {
        driver.quit();
    }
}
