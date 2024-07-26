package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.EmailProvider;
import com.automation.utils.ExtendManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BaseTest extends ExtendManager {

    HomePage homePage ;
    RegisterPage registerPage;
    LoginPage loginPage;

    String tempEmail;
    @BeforeTest
    public void set(){
        tempEmail = EmailProvider.getEmail();
    }

    @BeforeMethod
    public void setup() throws IOException {
        ConfigReader.init();
        DriverManager.inti();

        loginPage = new LoginPage();
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @AfterMethod
    public void close(){
        DriverManager.getDriver().quit();
    }

    public static String takeScreenShot() throws IOException {
        TakesScreenshot shot = (TakesScreenshot) DriverManager.getDriver();

        File file = shot.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int num = random.nextInt(100000)+1;

        String filepath = "src/test/resources/screenshots/img_"+num+".png";

        FileUtils.copyFile(file, new File(filepath));

        return System.getProperty("user.dir")+"/"+filepath;

    }

}
