package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id = "gender-male")
    WebElement maleGender;

    @FindBy(tagName = "h1")
    WebElement registerText;

    @FindBy(id = "FirstName")
    WebElement firstNameInput;

    @FindBy(id = "LastName")
    WebElement lastNameInput;

    @FindBy(name = "DateOfBirthDay")
    WebElement daySelect;

    @FindBy(name ="DateOfBirthMonth")
    WebElement monthSelect;

    @FindBy(name ="DateOfBirthYear")
    WebElement yearSelect;

    @FindBy(id="Email")
    WebElement emailInput;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(className = "ico-login")
    WebElement loginLink;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    WebElement registerResultText;


    public boolean verifyRegisterPage(){
        return registerText.isDisplayed();
    }

    public void selectGenderAsMale(){
        maleGender.click();
    }

    public void fillOnFirstNameInput(String firstnameKey){
        firstNameInput.sendKeys(ConfigReader.getPropertyValue(firstnameKey));
    }

    public void fillOnLastNameInput(String lastNameKey){
        lastNameInput.sendKeys(ConfigReader.getPropertyValue(lastNameKey));
    }

    public void selectDayOfDateOfBirth(String date){
        daySelect.click();
        daySelect.findElement(By.xpath(String.format("./option[@value='%s']",date))).click();
    }

    public void selectMonthOfDateOfBirth(String month){
        monthSelect.click();
        monthSelect.findElement(By.xpath(String.format("./option[text()='%s']",month))).click();

    }

    public void selectYearOfDateOfBirth(String year){
        yearSelect.click();
        yearSelect.findElement(By.xpath(String.format("./option[@value='%s']",year))).click();

    }

    public void fillEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void fillPasswordsInput(String passKey){
        passwordInput.sendKeys(ConfigReader.getPropertyValue(passKey));
        confirmPasswordInput.sendKeys(ConfigReader.getPropertyValue(passKey));
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public boolean verifyRegistration(){
        return registerText.isDisplayed() ;//&& registerText.getText().equals("Your registration completed");
    }

    public void  clickOnLoginLink(){
        loginLink.click();
    }

}
