package com.automation.steps;

import com.automation.pages.CellPhoneItemPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CellPhoneItemStep {

    CellPhoneItemPage cellPhoneItemPage = new CellPhoneItemPage();

    @Then("verify user is on cell phones items page")
    public void verify_user_is_on_cell_phones_items_page() {
        Assert.assertTrue(!cellPhoneItemPage.verifyUserIsOnCellPhonesItemsPage());
    }

    @When("user add first product into cart")
    public void userAddFirstProductIntoCart() {
        cellPhoneItemPage.userAddFirstProductIntoCart();
    }
}
