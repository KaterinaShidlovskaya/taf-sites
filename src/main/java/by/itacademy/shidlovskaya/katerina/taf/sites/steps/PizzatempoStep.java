package by.itacademy.shidlovskaya.katerina.taf.sites.steps;

import by.itacademy.shidlovskaya.katerina.taf.sites.pages.PizzatempoPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzatempoStep {

    PizzatempoPage page;

    public PizzatempoStep(ChromeDriver driver) {
        page = new PizzatempoPage(driver);
    }

    public PizzatempoStep getURLAndMaximizeWindowInChrome() {
        page.openBaseURL();
        return this;
    }

    public PizzatempoStep fillLoginFormAndSubmit(String email, String password) {
        page.sendKeysInputEmailAddress(email)
                .sendKeysInputPassword(password)
                .clickButtonSearch();
        return this;
    }

    public PizzatempoStep fillLoginFormWithEmptyData() {
        page.clickButtonSearch();
        return this;
    }

    public PizzatempoStep fillLoginFormWithIncorrectEmailAndSubmit(String email) {
        page.sendKeysInputEmailAddress(email)
                .clickButtonSearch();
        return this;
    }

    public PizzatempoStep fillLoginFormWithSomePassword(String password) {
        page.sendKeysInputPassword(password)
                .clickButtonSearch();
        return this;
    }

    public String getActualErrorMessage() {
        return page.getTextOfActualErrorMessage();
    }
}