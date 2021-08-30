package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

class BaseTestClass {

    protected WebDriver driver;


    @BeforeClass
    public void driverUp(){

        driver = new ChromeDriver();

    }

    @AfterClass
    public void driverQuit(){
        driver.quit();

    }


}
