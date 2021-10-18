package factoryMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFF implements WebDriverCreator {


    private WebDriverFF() {

    }


    @Override
    public WebDriver CreateWEbDriver() {
        return new FirefoxDriver();
    }
}
