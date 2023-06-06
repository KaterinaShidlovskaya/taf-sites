package by.itacademy.shidlovskaya.katerina.taf.sites.steps;

import by.itacademy.shidlovskaya.katerina.taf.sites.pages.PizzatempoPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {

    PizzatempoPage page;

    public PizzatempoStep(ChromeDriver driver) {
        page = new PizzatempoPage(driver);
    }

    public void getURLAndMaximizeWindowInChrome() {
        page.openBaseURL();
    }

    public void fillLoginFormAndSubmit(String email, String password) {
        page.sendKeysInputEmailAddress(email);
        page.sendKeysInputPassword(password);
        page.clickButtonSearch();
    }

    public void fillLoginFormWithEmptyData() {
        page.clickButtonSearch();
    }

    public void fillLoginFormWithIncorrectEmailAndSubmit(String email) {
        page.sendKeysInputEmailAddress(email);
        page.clickButtonSearch();
    }

    public void fillLoginFormWithSomePassword(String password) {
        page.sendKeysInputPassword(password);
        page.clickButtonSearch();
    }

    public String getActualErrorMessage() {
        return page.getTextOfActualErrorMessage();
    }
}