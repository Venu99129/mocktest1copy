package com.automation.utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class ExtendManager {


    static ExtentTest test;

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ExtendManager.test = test;
    }

    public static void addScreenshot() throws IOException {
        test.addScreenCaptureFromPath(takeScreenShot());
    }

    private static String takeScreenShot() throws IOException {
        TakesScreenshot shot = (TakesScreenshot) DriverManager.getDriver();

        File file = shot.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int num = random.nextInt(100000)+1;

        String filepath = "src/test/resources/screenshots/img_"+num+".png";

        FileUtils.copyFile(file, new File(filepath));

        return System.getProperty("user.dir")+"/"+filepath;

    }
}
