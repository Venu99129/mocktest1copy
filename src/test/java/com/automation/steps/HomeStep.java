package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep {

    HomePage homePage = new HomePage();

    @Given("user open the website")
    public void user_open_the_website() {
        homePage.getIntoHomePage();
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.verifyHomePage());
    }


    @When("user click on login")
    public void userClickOnLogin() {
        homePage.clickOnLoginLink();
    }
}
