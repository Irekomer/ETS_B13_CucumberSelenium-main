package com.eurotech.stepDefinitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DashboardMenu_StepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Then("The user should be able to see following menu")
    public void the_user_should_be_able_to_see_following_menu(List<String> expectedList) {
        System.out.println("expectedList.size() = " + expectedList.size());
        System.out.println("expectedList = " + expectedList);

//        List<String> actualList = new ArrayList<>();
//        for (WebElement element : dashboardPage.menuList) {
//            actualList.add(element.getText());
//        }
//        System.out.println("actualList.size() = " + actualList.size());
//        System.out.println("actualList = " + actualList);
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(expectedList,actualList);
    }
    @When("The user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userCredentials) {
        System.out.println("userCredentials = " + userCredentials);
        loginPage.login(userCredentials.get("userEmail"),userCredentials.get("password"));
        BrowserUtils.waitForVisibility(dashboardPage.welcomeMsg,5);
        Assert.assertTrue(dashboardPage.welcomeMsg.getText().contains(userCredentials.get("message")));
    }
    @Then("The user should be able to see following edit add menu")
    public void the_user_should_be_able_to_see_following_edit_add_menu(List<String> expectedList) {
        System.out.println("expectedList.size() = " + expectedList.size());
        System.out.println("expectedList = " + expectedList);
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.dashboardList);
        System.out.println("actualList = " + actualList);
        Assert.assertEquals(expectedList,actualList);
    }


}
