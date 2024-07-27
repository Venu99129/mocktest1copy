package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.automation.utils.CucmberReportManager;
import java.io.IOException;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println("starting scenario "+ scenario.getName());
        CucmberReportManager.setScenario(scenario);
        ConfigReader.init();
        DriverManager.inti();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if(scenario.isFailed()){
            CucmberReportManager.addaScreenshot();
        }
        DriverManager.getDriver().quit();
    }



}
