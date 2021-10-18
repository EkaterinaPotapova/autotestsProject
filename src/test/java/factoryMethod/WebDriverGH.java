package factoryMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverGH implements WebDriverFactoryMethod {



    private WebDriverGH() {

    }


    @Override
    public WebDriver CreateWEbDriver() {
        return new ChromeDriver();
    }
}
