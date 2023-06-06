package by.itacademy.shidlovskaya.katerina.taf.sites.steps;

import by.itacademy.shidlovskaya.katerina.taf.sites.pages.DominosPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class DominosStep {
    DominosPage page;

    public DominosStep(ChromeDriver driver) {
        page = new DominosPage(driver);
    }
    public void openURLAndClickButtonLogin(){
        page.openBaseURL();
        page.clickButtonPopUpClose();
        page.clickButtonLogin();
    }
    public void fillLoginFormWithInvalidEmailAndSomePassword(String invalidEmail, String password) {
        page.sendKeysInputEmailAddress(invalidEmail);
        page.sendKeysInputPassword(password);
        page.clickButtonSingIn();
    }
    public void fillLoginFormWithAnyEmailAndPassword(String email, String password) {
        page.sendKeysInputEmailAddress(email);
        page.sendKeysInputPassword(password);
        page.clickButtonSingIn();
    }
    public String getActualErrorMessage(){
        String actualErrorMessage = page.getTextErrorMessage();
        return actualErrorMessage;
    }
}