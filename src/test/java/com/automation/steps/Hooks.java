package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.EmailProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    String tempEmail;
    @Before
    public void setUp() throws IOException {
        tempEmail = EmailProvider.getEmail();
        ConfigReader.init();
        DriverManager.inti();
    }

    @After
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }

}
