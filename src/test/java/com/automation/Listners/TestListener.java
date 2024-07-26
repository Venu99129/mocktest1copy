package com.automation.Listners;


import com.automation.tests.BaseTest;
import com.automation.utils.ExtendManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListener implements ITestListener {

    public ExtentReports extentReports;
    public ExtentTest test;
    public ExtentSparkReporter sparkReporter;

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = extentReports.createTest(result.getMethod().getMethodName());
        ExtendManager.setTest(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            test.addScreenCaptureFromPath(BaseTest.takeScreenShot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        String filepath =  "src/test/resources/reports/avinstackReport.html";
        ITestListener.super.onStart(context);
        sparkReporter = new ExtentSparkReporter(filepath);
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.setSystemInfo("teter","Venumadhav");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extentReports.attachReporter(sparkReporter);
        extentReports.flush();

    }
}