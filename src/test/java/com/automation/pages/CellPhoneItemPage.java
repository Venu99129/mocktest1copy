package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CellPhoneItemPage extends BasePage{

    @FindBy(xpath = "//h1")
    WebElement cellPhoneText;

    @FindBy(xpath = "//div[@class='item-box'][1]//button[text()='Add to cart']")
    WebElement firstCellPhone;

    @FindBy(className = "ico-cart")
    WebElement shoppingCart;

    @FindBy(xpath = "//div[@class='item-box'][1]//h2/a")
    WebElement firstMobileEle;

    public static String mobileName;

    public boolean verifyUserIsOnCellPhonesItemsPage() {
        return cellPhoneText.isDisplayed();
    }

    public void userAddFirstProductIntoCart() {
        firstCellPhone.click();
        mobileName = firstMobileEle.getText();
        shoppingCart.click();
    }

}







