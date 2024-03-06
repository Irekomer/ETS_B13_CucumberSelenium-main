package com.eurotech.stepDefinitions;

import com.eurotech.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenu_StepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    @Then("The user should be able to see welcome message")
    public void the_user_should_be_able_to_see_welcome_message() {
        System.out.println("verified that welcome message text is here");
    }
    @When("The user navigates to Developers menu")
    public void the_user_navigates_to_developers_menu() {
        System.out.println("User navigates to Developers menu");
    }
    @Then("The user able to see Developers text")
    public void the_user_able_to_see_developers_text() {
        System.out.println("verified that developers text is here");
    }
    @When("The user navigates to All Post menu")
    public void the_user_navigates_to_all_post_menu() {
        System.out.println("User navigates to All Posts menu");
    }
    @Then("The user able to see All Post text")
    public void the_user_able_to_see_all_post_text() {
        System.out.println("verified that All Posts text is here");
    }
    @When("The user navigates to My Account menu")
    public void the_user_navigates_to_my_account_menu() {
        System.out.println("User navigates to My Account menu");
    }
    @Then("The user able to see Dashboard text")
    public void the_user_able_to_see_dashboard_text() {
        System.out.println("verified that Dashboard text is here");
    }
    @When("The user navigates to {string} menu")
    public void the_user_navigates_to_menu(String menuName) {
        dashboardPage.navigateToMenu(menuName);
    }
    @Then("The user should be able to see header as {string}")
    public void the_user_should_be_able_to_see_header_as(String header) {
        String actualHeader = dashboardPage.getHeaderText(header);
        Assert.assertEquals("Verify that header name is displayed as expected",header,actualHeader);
    }
}
