package com.automation.utils;

import com.aventstack.extentreports.ExtentTest;


public class ExtendManager {


    static ExtentTest test;

    public static ExtentTest getTest() {
        return test;
    }

    public static void setTest(ExtentTest test) {
        ExtendManager.test = test;
    }
}
