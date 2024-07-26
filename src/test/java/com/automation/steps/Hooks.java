package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.EmailProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.sql.SQLOutput;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println("starting scenario "+ scenario.getName());
        ConfigReader.init();
        DriverManager.inti();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if(scenario.isFailed()){
            scenario.attach(takeScreenShot(),"image/png"," Failed Snap");
        }
        DriverManager.getDriver().quit();
    }

    public byte[] takeScreenShot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}
