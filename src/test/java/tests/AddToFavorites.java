package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectModel.MyFavoritesPage;
import pageObjectModel.ProductDetailsPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddToFavorites extends BaseTestClass{

    private ProductDetailsPage productDetailsPage;
    private MyFavoritesPage myFavoritesPage;

    @BeforeClass
    public void driverUp() {
        try {
            nodeUrl = "http://192.168.0.152:32288/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait10 = new WebDriverWait(driver, 10);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addToFavoritesScenario()  {

        productDetailsPage=new ProductDetailsPage(driver)
                .openPage()
                .addToFavorites();
        WebElement numberOfFavorites = productDetailsPage.numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Test(dependsOnMethods = {"addToFavoritesScenario"})
    public void checkFavoritesScenario()  {

        myFavoritesPage =new MyFavoritesPage(driver)
                .openPage();
        WebElement bookInFavorites = myFavoritesPage.numberOfFavorites();
        Assert.assertNotNull(bookInFavorites);
    }
}
