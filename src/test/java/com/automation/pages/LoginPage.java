package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(tagName = "h1")
    WebElement verifyText;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement loginButton;

    public void sendEmailInput(String emailKey){
        emailInput.sendKeys(emailKey);
    }

    public void sendPasswordInput(String passwordKey){
        passwordInput.sendKeys(passwordKey);
    }

    public boolean verifyLoginPage(){
        return verifyText.isDisplayed() ;
    }

    public String getVerifyText(){
        return verifyText.getText();
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
