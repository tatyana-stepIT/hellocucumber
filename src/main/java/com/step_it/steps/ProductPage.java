package com.step_it.steps;

import com.step_it.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {

    private By productDescription = By.className("inventory_item_name");
    private By addRemoveBtn = By.tagName("button");

    @FindBy(css = ".inventory_item_description")
    private List<WebElement> productNames;


    public void waitUntilDisplayed() {
        getPageLoader().isListVisible(productNames, 3);
    }


    public void addProductToCart(String productName) {
        getProduct(productName).findElement(addRemoveBtn).click();
    }

    private WebElement getProduct(String productName) {
        for (WebElement product : productNames) {
            WebElement description = product.findElement(productDescription);
            if (productName.equalsIgnoreCase(description.getText())) {
                return product;
            }
        }
        throw new NoSuchElementException("Couldn't find the element " + productName);
    }


}
