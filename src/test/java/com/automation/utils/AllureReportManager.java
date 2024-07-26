package com.automation.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class AllureReportManager {


    public static void attachScreenshot(){
        TakesScreenshot shot = (TakesScreenshot) DriverManager.getDriver();
        byte[] scrren = shot.getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("screen shot ",new ByteArrayInputStream(scrren));
    }


    public static void attachLog(String massage){
        Allure.addAttachment("log",massage);
    }


}
