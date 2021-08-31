package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchBookTest extends BaseTestClass {



    @Test
    public void testScenario() throws InterruptedException {




        //Перейти на страницу
        driver.get("http://ozon.ru/");

        wait10.until(CustomWaitCondition.jQueryAJAXsCompleted());
        //здесь вызываем ожидание самописного условия , что все AJAX запросы прошли, и загрузка страницы завершилась


        //
        wait10.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder[contains(.,'Искать')]]")));
        //Будем ждать 10 секунд пока не появится элемент 'Искать',

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
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
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
            Assert.assertNotNull(driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in Data-Driven" +
                    " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                    "TestNG']")), "the book was not added to Cart");


        }

    @Test(dependsOnMethods = { "addToCartScenario" })
    public void removeFromCartScenario() throws InterruptedException {
        WebElement removeFromCartBtn = driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in " +
                "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
                " Java, and TestNG']/../..//span[contains(.,'Удалить')]"));
        removeFromCartBtn.click();
        Thread.sleep(200);

        WebElement fromCartBtn = driver.findElement(By.xpath("//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
                "//div[@class='kxa6']"));
        fromCartBtn.click();
        Assert.assertNotNull(driver.findElement(By.xpath("//h1[contains(.,'Корзина пуста')]")), "the book " +
                "was not removed from Cart");
        Thread.sleep(20000);
    }
}
