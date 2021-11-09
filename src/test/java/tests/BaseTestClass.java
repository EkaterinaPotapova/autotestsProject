package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

class BaseTestClass {

   /* protected WebDriver driver;
    private WebDriverWait wait10;
    private int stringLenght;*/

    @BeforeClass
    public void driverUp() {
       /* WebDriverManager.chromedriver().setup();
        WebDriverCreator creator = new WebDriverGH();
        driver = creator.createWebDriver();
        driver = new CustomDriverDecorator(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
        wait10 = new WebDriverWait(driver, 10);
        stringLenght = 10;*/
    }

    @AfterClass
    public void driverQuit() {
        //driver.quit();
    }
}
