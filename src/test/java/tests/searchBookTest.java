package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class searchBookTest extends BaseTestClass {



    @Test
    public void testScenario() throws InterruptedException {


        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*driver.get("http://mail.ru/");
        WebElement searchInput=  driver.findElement(By.id("q"));
        searchInput.sendKeys("selenium java");
        Thread.sleep(2000);
        WebElement searchBtn=  driver.findElement(By.xpath("//*[@id='search:submit']"));
        searchBtn.click();*/

        //Перейти на страницу
        driver.get("http://ozon.ru/");

        //Найти элемент
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder[contains(.,'Искать')]]"));

        //Заполнить поле
        searchInput.sendKeys("selenium java");

        //Подождать 2 секунды
        Thread.sleep(2000);
        //WebElement searchBtn=  driver.findElement(By.xpath("//*[@aria-label='Поиск']"));

        //Найти элемент Поиск по css
        WebElement searchBtn = driver.findElement(By.cssSelector("[aria-label=Поиск]"));

        //Нажать кнопку поиска
        searchBtn.click();

        //Подождать 5 секунд
        driver.manage().timeouts().implicitlyWait(500000, TimeUnit.SECONDS);
        Thread.sleep(2000);


        //проверить что книжка нашлась
        Assert.assertNotNull(driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design in Data-Driven" +
                " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                "TestNG'])[2]")), "the book was not found");
    }

        @Test(dependsOnMethods = { "testScenario" })
        public void addToCartScenario() {
            WebElement addToCartBtn = driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design " +
                    "in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver," +
                    " AppiumDriver, Java, and TestNG'])[2]/../../..//div[text() = 'В корзину']"));
            addToCartBtn.click();
            driver.get("https://www.ozon.ru/cart");
          /*  Assert.assertNotNull(driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design in Data-Driven" +
                    " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                    "TestNG'])[2]")), "the book was not added to Cart");*/


        }

    @Test(dependsOnMethods = { "addToCartScenario" })
    public void removeFromCartScenario() throws InterruptedException {
        WebElement removeFromCartBtn = driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in " +
                "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
                " Java, and TestNG']/../..//span[contains(.,'Удалить')]"));
        removeFromCartBtn.click();
        Thread.sleep(200);
      /* String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);// switch to popup window
        WebElement fromCartBtn = driver.findElement(By.xpath("//span/span[contains(.,'Удалить')]"));
        fromCartBtn.click();
        driver.switchTo().window(parentWindowHandler);*/
        /*Alert alert = driver.switchTo().alert();
        alert.accept();*/
        //driver.switchTo().alert().accept();

        //String MainWindow=driver.getWindowHandle();

        // To handle all new opened window.
        /*Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();

        while(i1.hasNext())
        {
            String ChildWindow=i1.next();

            if(!MainWindow.equalsIgnoreCase(ChildWindow))
            {

                // Switching to Child window
                driver.switchTo().window(ChildWindow);
                WebElement fromCartBtn = driver.findElement(By.xpath("//*[contains(.,'Удалить')]"));
                fromCartBtn.click();



                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        Thread.sleep(20000);*/
        WebElement fromCartBtn = driver.findElement(By.xpath("//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
                "//div[@class='kxa6']"));
        fromCartBtn.click();
        Assert.assertNotNull(driver.findElement(By.xpath("//h1[contains(.,'Корзина пуста')]")), "the book " +
                "was not removed from Cart");
        Thread.sleep(20000);
    }
}
