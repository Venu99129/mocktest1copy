package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".ico-register")
    WebElement registerLink;

    @FindBy(className = "ico-login")
    WebElement loginLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersTab;

    public void getIntoHomePage(){
        driver.get(ConfigReader.getPropertyValue("base.url"));
    }

    public boolean verifyHomePage(){
        return computersTab.isDisplayed();
    }

    public void clickOnRegisterLink(){
        registerLink.click();
    }

    public void  clickOnLoginLink(){
        loginLink.click();
    }


}