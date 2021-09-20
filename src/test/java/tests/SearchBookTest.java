package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjectModel.CartPage;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SearchBookTest extends BaseTestClass {

    private SearchResultPage searchResultPageObject;
    private CartPage cartPageOblect;

 /*   @BeforeClass
    public void driverUp() {
        try {
            nodeUrl = "http://192.168.0.152:24963/wd/hub";
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
    }*/

    @Test
    public void testScenario() {
        searchResultPageObject = new HomePage(driver)//инициируем драйвер
                .openPage() //открыли страницу, на выходе объект класса HomePage
                .seachBook("selenium java");//к объекту класса HomePage применяем seachBook, получаем объект
        // SearchResultPage в которые передаем драйвер и term. Собираем конструктором такой обект.
        WebElement book = searchResultPageObject.seachResult();// к объекту класса SearchResultPage применяем метод
        // seachResult, который возвращает объект типа WebElement
        Assert.assertNotNull(book); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице результатов поиска
    }

    @Test(dependsOnMethods = {"testScenario"})
    public void addToCartScenario() {
        searchResultPageObject.addToCart();
        cartPageOblect = new CartPage(driver)//инициируем драйвер
                .openPage(); //открыли страницу, на выходе объект класса CartPage
        WebElement bookInCart = cartPageOblect.bookInCartItem();//возвращает элемент который найден
        Assert.assertNotNull(bookInCart); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице Корзины
    }

    @Test(dependsOnMethods = {"addToCartScenario"})
    public void removeFromCartScenario() {
        cartPageOblect.removeFromCart();
        WebElement emptyCartElement = cartPageOblect.cartEmptyItem();//возвращает элемент который найден
        Assert.assertNotNull(emptyCartElement); // проверяем что все что делали до на выходе дало элемент,
        // который найден на странице Корзины
    }
}
