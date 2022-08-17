package com.step_it.steps;


import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
@AllArgsConstructor
public class CommonSteps {

    private LoginPage loginPage;
    private MainPage mainPage;


//    public CommonSteps(LoginPage loginPage, MainPage mainPage) {
//        this.loginPage = loginPage;
//        this.mainPage = mainPage;
//    }

    public void checkLoginPageIsOpen() {
        log.info("Check login page is open");
        assertThat(loginPage.isLogoDisplayed()).as("The login page is not displayed").isTrue();
    }

    public void checkUserIsLoggedIn() {
        log.info("Check user is logged in");
        assertThat(mainPage.isTitleDisplayed()).as("The login page is not displayed").isTrue();
    }

    public void checkCartCounterUpdated(int quantity) {
        log.info("Check cart is updated");
        checkCartCounter(quantity, "The counter was not updated");

    }

    public void checkCartEmpty() {
        checkCartCounter(0, "The cart is not empty");
    }

    private void checkCartCounter(int i, String assertionMessage) {
    assertThat(mainPage.getProductCountsInCart()).as(assertionMessage).isEqualTo(i);
    }
}
