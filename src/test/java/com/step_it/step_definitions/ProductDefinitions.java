package com.step_it.step_definitions;

import com.step_it.steps.CommonSteps;
import com.step_it.steps.ProductSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ProductDefinitions {

    private ProductSteps productSteps;
    private CommonSteps commonSteps;

    @Given("the app is on products page")
    public void theAppIsOnProductsPage() {
        productSteps.checkProductPageIsOpen();

    }

    @When("the user adds {} to cart")
    public void theUserAddsProductToCart(String product) {
        commonSteps.checkCartEmpty();
        productSteps.addProductToCart(product);
    }

    @When("the user adds to cart product")
    public void theUserAddsToCartProduct(List<String> products) {
        for (String product:products) {
            productSteps.addProductToCart(product);
        }

    }
}
