package com.automation.tests;

import com.automation.utils.ExtendManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NopCommerceDemo1Test extends BaseTest{



    @Test(priority = 1)
    public void registerTest() throws IOException {
        ExtentTest test = ExtendManager.getTest();
        homePage.getIntoHomePage();
        Assert.assertTrue(homePage.verifyHomePage());
        test.addScreenCaptureFromPath(takeScreenShot());

        homePage.clickOnRegisterLink();

        Assert.assertTrue(registerPage.verifyRegisterPage());
        test.addScreenCaptureFromPath(takeScreenShot());

        test.info("filling register page details");

        registerPage.selectGenderAsMale();
        registerPage.fillOnFirstNameInput("user.firstName");
        registerPage.fillOnLastNameInput("user.lastName");

        registerPage.selectDayOfDateOfBirth("2");
        registerPage.selectMonthOfDateOfBirth("October");
        registerPage.selectYearOfDateOfBirth("1999");

        registerPage.fillEmailInput(tempEmail);
        registerPage.fillPasswordsInput("user.password");

        registerPage.clickOnRegisterButton();

        Assert.assertTrue(registerPage.verifyRegistration());
        test.info("test successfully registered");
        test.addScreenCaptureFromPath(takeScreenShot() );


    }

    @Test(priority = 3)
    public void loginTest() throws IOException {
        ExtentTest test = ExtendManager.getTest();
        homePage.getIntoHomePage();
        Assert.assertTrue(homePage.verifyHomePage());

        homePage.clickOnLoginLink();
        Assert.assertTrue(loginPage.verifyLoginPage());
        Assert.assertEquals(loginPage.getVerifyText(),"Welcome, Please Sign In!");
        test.info("we are in login page");

        loginPage.sendEmailInput(tempEmail);
        loginPage.sendPasswordInput("user.password");
        loginPage.clickOnLoginButton();

        test.info("we are success login ");

        Assert.assertTrue(homePage.verifyHomePage());
    }
}
