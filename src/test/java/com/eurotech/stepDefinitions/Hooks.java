package com.eurotech.stepDefinitions;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        //System.out.println("\t This is coming from Before method");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        //System.out.println("\t This is coming from After method");
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpDB(){
        //System.out.println("\t Connection DB");
    }
    @After("@db")
    public void tearDownDB(){
        //System.out.println("\t Disconnection DB");
    }

}
