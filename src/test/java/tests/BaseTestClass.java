package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

class BaseTestClass {

    protected WebDriver driver;
    protected WebDriverWait wait10;



    @BeforeClass
    public void driverUp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
        wait10 = new WebDriverWait(driver,100);
        //будем использовать wait объеркт класса WebDriverWait
        // для вставки ожиданий по 10 секунд таймаута ожидания выполнения событий

    }

    @AfterClass
    public void driverQuit(){
        driver.quit();

    }


}
