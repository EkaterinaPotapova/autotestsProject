package sIngleton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

    public static WebDriver driver=null;

    private WebDriverSingleton() {

    }

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager driverManager = WebDriverManager.getInstance();
            driver = driverManager.capabilities(new ChromeOptions()).create();
        }
        return driver;
    }

    public static void driverQuit() {
        WebDriverSingleton.getInstance().quit();
        driver=null;
    }
}
