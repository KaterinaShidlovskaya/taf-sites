package by.itacademy.shidlovskaya.katerina.taf.sites;

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
    public void fillLoginFormWithInvalidEmailAndAnyPassword(String invalidEmail, String password) {
        page.sendKeysInputEmailAddress(invalidEmail);
        page.sendKeysInputPassword(password);
        page.clickButtonSingIn();
    }
    public void fillLoginFormWithAnyEmailAndPassword(String email, String password) {
        page.sendKeysInputEmailAddress(email);
        page.sendKeysInputPassword(password);
        page.clickButtonSingIn();
    }
}