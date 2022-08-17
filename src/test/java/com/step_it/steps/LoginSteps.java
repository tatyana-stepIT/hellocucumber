package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginSteps {
    private LoginPage loginPage;
    private MainPage mainPage;

    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    public void logout() {
        mainPage.logout();
    }
}
