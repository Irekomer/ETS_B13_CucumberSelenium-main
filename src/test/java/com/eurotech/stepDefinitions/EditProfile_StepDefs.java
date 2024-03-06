package com.eurotech.stepDefinitions;

import com.eurotech.pages.EditProfilePage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EditProfile_StepDefs {
    EditProfilePage editProfilePage=new EditProfilePage();
    @When("The user selects status {string}")
    public void the_user_selects_status(String status) {
        editProfilePage.selectMenu(status);
    }
    @When("The user slides the slider {int}")
    public void the_user_slides_the_slider(int yearNum) {
        editProfilePage.sleder(yearNum);
    }
    @When("The user adds {string} {string}")
    public void the_user_adds(String inputBoxName, String userInfo) {
        editProfilePage.addInfo(inputBoxName, userInfo);
    }
    @When("The user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
        editProfilePage.editprofile_submitBtn.click();
    }
    @Then("The user verifies that profile info has been successfully updated")
    public void the_user_verifies_that_profile_info_has_been_successfully_updated() {
        Assert.assertTrue(editProfilePage.profielUpdateMessage.isDisplayed());
    }

}
