package com.automation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHomePage extends BasePage{

    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountText;

    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[text()='Electronics ']")
    WebElement electronicsButton;

    @FindBy(xpath = "//a[text()=' Cell phones ']")
    WebElement cellPhoneButton;


    public boolean verifyUserSuccessfullyLogIn() {
        return myAccountText.isDisplayed();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void clickOnCellPhones() {
        electronicsButton.click();
        cellPhoneButton.click();
    }
}
