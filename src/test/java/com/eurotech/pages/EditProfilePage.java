package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage{

    @FindBy(id = "editprofile-from-status-select")
    public WebElement selectStatus;
    @FindBy(id = "editprofile-from-addsocial-btn")
    public WebElement editprofile_submitBtn;
    @FindBy(xpath = "//*[.='Profile Updated']")
    public WebElement profielUpdateMessage;

    public void selectMenu(String status){
        Select select=new Select(selectStatus);
        select.selectByValue(status);
    }

    public void sleder(int yearNum){
        WebElement slider= Driver.get().findElement(By.id("slider-input"));
        int currentYear= Integer.parseInt(slider.getAttribute("value"));
        for (int i = 0; i <currentYear ; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
        BrowserUtils.waitFor(1);
        for (int i = 0; i < yearNum; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        BrowserUtils.waitFor(1);
    }

    public void addInfo(String inputBoxName,String userInfo){
        WebElement infoCategory = Driver.get().findElement(By.name(inputBoxName));
        infoCategory.clear();
        infoCategory.sendKeys(userInfo);
    }

}
