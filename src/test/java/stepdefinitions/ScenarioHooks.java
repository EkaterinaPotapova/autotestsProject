package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import myReporting.MyLogger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import sIngleton.WebDriverSingleton;
import utils.MyUtil;

import java.io.File;
import java.io.IOException;

public class ScenarioHooks {


    @Before
    public void driverUp() {
        WebDriverSingleton.getInstance();
    }

    @After
    public void driverQuit() {
        try {
            WebDriverSingleton.webDriverQuit();
        } catch (WebDriverException e) {
            MyLogger.error("This is WebDriverException found "+e.getMessage());
            MyUtil.takeScreenshots(WebDriverSingleton.getInstance());
        }

    }

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            MyUtil.takeScreenshots(WebDriverSingleton.getInstance());
        }
    }
}
