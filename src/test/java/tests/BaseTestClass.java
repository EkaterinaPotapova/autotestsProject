package tests;

import SIngleton.WebDriverSingleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

class BaseTestClass {

    protected WebDriver driver;
    protected WebDriverWait wait10;
    protected int stringLenght;

    @BeforeClass
    public void driverUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
        wait10 = new WebDriverWait(driver, 10);
        stringLenght = 10;
    }

    @AfterClass
    public void driverQuit() {
        driver.quit();
    }
}
