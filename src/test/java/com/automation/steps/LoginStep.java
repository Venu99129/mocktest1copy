package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStep {

    LoginPage loginPage = new LoginPage();

    @Then("verify user is on login page")
    public void verify_user_is_on_login_page() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("user enter valid login credentials")
    public void userEnterValidLoginCredentials() {
        loginPage.sendEmailInput("zxcm@gmail.com");
        loginPage.sendPasswordInput("user.password");
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
       
    }
}
