package factoryMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGH implements WebDriverCreator {



    public WebDriverGH() {

    }


    @Override
    public WebDriver CreateWEbDriver() {
        return new ChromeDriver();
    }
}
