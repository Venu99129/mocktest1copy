package com.automation.steps;


import com.automation.pages.UserHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserHomeStep {

    UserHomePage userHomePage = new UserHomePage();

    @Then("verify user is on userHome page")
    public void verify_user_is_on_user_home_page() {
        Assert.assertTrue(userHomePage.verifyUserSuccessfullyLogIn());
    }

    @When("user click on cell phones")
    public void userClickOnCellPhones() {
        userHomePage.clickOnCellPhones();
    }
}