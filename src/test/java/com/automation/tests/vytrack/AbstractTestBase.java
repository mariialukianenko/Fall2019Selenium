package com.automation.tests.vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTestBase {

    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest() {
        report = new ExtentReports();
        String reportPath = "";
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reportitself
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");

    }

    @AfterTest
    public void afterTest(){
        report.flush(); //to release a report
    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }


    @AfterMethod
    public void teardown(ITestResult iTestResult) throws Exception{
        //ITestResult class describe the result of a test
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            //screnshot will have a name of the test
           String screenshotPath =  BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); //attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath, "Failed"); //attach screenshot
            test.fail(iTestResult.getThrowable()); //attach console output
        }

        BrowserUtils.wait(2);
        Driver.closeDriver();
    }

}
