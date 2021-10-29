package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import sIngleton.WebDriverSingleton;

public class ScenarioHooks {


    @Before
    public void driverUp() {
        WebDriverSingleton.getInstance();
    }

    @After
    public void driverQuit() {
        WebDriverSingleton.driverQuit();
    }
}
