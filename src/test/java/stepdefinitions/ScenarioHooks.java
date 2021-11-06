package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import myReporting.MyLogger;
import org.openqa.selenium.WebDriverException;
import sIngleton.WebDriverSingleton;
import utils.MyUtil;


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

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            MyUtil.takeScreenshots(WebDriverSingleton.getInstance());
        }
    }
}
