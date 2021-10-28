package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import factoryMethod.WebDriverCreator;
import factoryMethod.WebDriverGH;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import sIngleton.WebDriverSingleton;

public class ScenarioHooks {
    public static WebDriver driver;

    @Before
    public void driverUp() {
        System.out.println("****---Before");
        WebDriverSingleton.getInstance();
    }

    @AfterSuite
    public void driverQuit() {
        System.out.println("****---After");
        WebDriverSingleton.getInstance().quit();
    }
}
