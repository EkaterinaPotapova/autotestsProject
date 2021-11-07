package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
            MyLogger.error("This Scenario ended with status "+scenario.getStatus());
            MyUtil.takeScreenshots(WebDriverSingleton.getInstance());
        }
    }
}
