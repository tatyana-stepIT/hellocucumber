package com.step_it.step_definitions;

import com.step_it.steps.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommonDefinitions {

    private CommonSteps commonSteps;

    @Given("the app login page is open")
    public void theAppLoginPageIsOpen() {
        commonSteps.checkLoginPageIsOpen();
    }

    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
        commonSteps.checkUserIsLoggedIn();
    }

    @Then("the cart counter is updated by {int}")
    public void theCartCounterIsUpdatedBy(int quantity) {
        commonSteps.checkCartCounterUpdated(quantity);
    }

    @And("the cart is empty")
    public void theCartIsEmpty() {
        commonSteps.checkCartEmpty();
    }
}
