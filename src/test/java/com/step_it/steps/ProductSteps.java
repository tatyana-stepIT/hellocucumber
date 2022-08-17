package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@AllArgsConstructor
public class ProductSteps {

    private ProductPage productPage;

    public void addProductToCart(String product) {
        log.info("addProductToCart");
        productPage.addProductToCart(product);
    }

    public void checkProductPageIsOpen() {
        log.info("Check product page is open");
        productPage.waitUntilDisplayed();
    }
}
