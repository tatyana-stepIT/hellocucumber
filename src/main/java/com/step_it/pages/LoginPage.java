package com.step_it.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = ".login_logo")
    private WebElement logo;

    @FindBy(css = "#user-name")
    private WebElement username_input;

    @FindBy(css = "#password")
    private WebElement password_input;

    @FindBy(css = "#login-button")
    private WebElement loginBtn;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void login(String username, String password) {
        username_input.sendKeys(username);
        password_input.sendKeys(password);
        loginBtn.click();
    }
}
