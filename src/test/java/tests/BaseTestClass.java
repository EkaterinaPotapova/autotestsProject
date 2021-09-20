package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class BaseTestClass {

    protected WebDriver driver;
    protected String nodeUrl;
    protected WebDriverWait wait10;

  /*  @BeforeClass
    public void driverUp(){
        try {
            nodeUrl="http://192.168.0.152:32288/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeUrl), capabilities );
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait10 = new WebDriverWait(driver,10);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        // driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
       // wait10 = new WebDriverWait(driver,10);
        //будем использовать wait объеркт класса WebDriverWait
        // для вставки ожиданий по 10 секунд таймаута ожидания выполнения событий
    }*/

    @BeforeClass
    public void driverUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
        wait10 = new WebDriverWait(driver,10);
        //будем использовать wait объеркт класса WebDriverWait
        // для вставки ожиданий по 10 секунд таймаута ожидания выполнения событий
    }

    @AfterClass
    public void driverQuit(){
        driver.quit();
    }

}
