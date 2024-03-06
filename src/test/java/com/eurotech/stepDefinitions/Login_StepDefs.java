package com.eurotech.stepDefinitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
//    ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch13_DevEx.xlsx","Test Data");
//    List<Map<String, String>> dataList = excelUtil.getDataList();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        //System.out.println("I open the browser and navigate to DevEx web page");
        //String url = ConfigurationReader.get("url");
        //Driver.get().get(url);
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters teacher credentials")
    public void the_user_enters_teacher_credentials() {
        //System.out.println("I enter teacher username and password then click login button");
        loginPage.loginAsTeacher();
    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
       // System.out.println("I verify that the URL is changed to dashboard");
        //Assert.assertTrue(100<99);
        String actualMessage = dashboardPage.welcomeMsg.getText();
        Assert.assertTrue(actualMessage.contains("Welcome"));
    }

    @When("The user enters student credentials")
    public void the_user_enters_student_credentials() {
        //System.out.println("I enter student username and password then click login button");
        loginPage.loginAsStudent();
    }
    @When("The user enters developer credentials")
    public void the_user_enters_developer_credentials() {
        //System.out.println("I enter developer username and password then click login button");
        loginPage.loginAsDeveloper();
    }
    @When("The user enters SDET credentials")
    public void the_user_enters_sdet_credentials() {
        //System.out.println("I enter SDET username and password then click login button");
        loginPage.loginAsStudent();
    }
    @When("The user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        loginPage.login(username,password);
    }
    @Then("The welcome message contains {string}")
    public void the_welcome_message_contains(String user) {
        System.out.println("user = " + user);
        Assert.assertTrue(dashboardPage.welcomeMsg.getText().contains(user));
    }
    @Then("The warning message should contain {string}")
    public void the_warning_message_should_contain(String expectedMessage) {
        // To find totally disappearing warning message;
//        String validationMessage = loginPage.userEmail.getAttribute("validationMessage");
//        System.out.println("validationMessage = " + validationMessage);
//        Assert.assertEquals(expectedMessage,validationMessage);
//
        BrowserUtils.waitFor(2);
        String actualMessage = loginPage.getDisappearingWarningMessage(expectedMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @When("The user enters {string} and row number {int}")
    public void the_user_enters_and_row_number(String sheetName, int  rowNumber) {
//        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch13_DevEx.xlsx",sheetName);
//        List<Map<String, String>> dataList = excelUtil.getDataList();
        //loginPage.login(dataList.get(0).get("Username"),dataList.get(0).get("Password"));
        //loginPage.login(dataList.get(rowNumber).get("Username"),dataList.get(rowNumber).get("Password"));
        loginPage.login(loginPage.getDataList(sheetName).get(rowNumber).get("Username"),//userEmail
                        loginPage.getDataList(sheetName).get(rowNumber).get("Password") //password
                        );
    }
    @Then("The warning message should contains {string} {int}")
    public void the_warning_message_should_contains(String sheetName,int rowNumber) {
        String actualMessage = dashboardPage.welcomeMsg.getText();
        System.out.println("actualMessage = " + actualMessage);
        //Assert.assertTrue(actualMessage.contains(dataList.get(rowNumber).get("Name")));
        Assert.assertTrue(actualMessage.contains(
                dashboardPage.getDataList(sheetName).get(rowNumber).get("Name")));

    }
    @Then("The user verifies that {string} info in excel {string} {int}")
    public void the_user_verifies_that_info_in_excel(String infoTitle, String sheetName,int rowNumber) {
        String actualInfoTitle= dashboardPage.getTextCommon(
                dashboardPage.getDataList(sheetName).get(rowNumber).get(infoTitle));
        System.out.println("actualInfoTitle = " + actualInfoTitle);
        Assert.assertEquals(dashboardPage.getDataList(sheetName).get(rowNumber).get(infoTitle),
                            actualInfoTitle
                            );
    }

}
