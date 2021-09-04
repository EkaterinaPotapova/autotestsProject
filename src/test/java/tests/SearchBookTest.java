package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.CartPage;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class SearchBookTest extends BaseTestClass {

    private SearchResultPage srp;
    private CartPage crdp;


    @Test
    public void testScenario()  {

        srp =new HomePage(driver).//инициируем драйвер
                openPage(). //открыли страницу, на выходе объект класса HomePage
                seachBook("selenium java");//к объекту класса HomePage применяем seachBook, получаем объект SearchResultPage в которые передаем драйвер и term. Собираем конструктором такой обект.

        WebElement book =srp.seachResult();// к объекту класса SearchResultPage применяем метод seachResult, который возвращает объект типа WebElement,




        Assert.assertNotNull(book); // проверяем что все что делали до на выходе дало элемент, который найден на странице результатов поиска





/*

        //Перейти на страницу
        driver.get("http://ozon.ru/");

        wait10.until(CustomWaitCondition.jQueryAJAXsCompleted());
        //здесь вызываем ожидание самописного условия , что все AJAX запросы прошли, и загрузка страницы завершилась

        wait10.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder[contains(.,'Искать')]]")));
        //Будем ждать 10 секунд пока не появится элемент 'Искать',

        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder[contains(.,'Искать')]]"));

        //Заполнить поле
        searchInput.sendKeys("selenium java");

        //Найти элемент Поиск по css
        WebElement searchBtn = driver.findElement(By.cssSelector("[aria-label=Поиск]"));
        searchBtn.click();
*/
        /*
        //Подождать 5 секунд
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        //проверить что книжка нашлась
        Assert.assertNotNull(driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design in Data-Driven" +
                " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                "TestNG'])[2]")), "the book was not found");
        */
    }

    @Test(dependsOnMethods = {"testScenario"})
    public void addToCartScenario() {
        srp.addToCart();
        /*WebElement addToCartBtn = driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design " +
                "in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver," +
                " AppiumDriver, Java, and TestNG'])[2]/../../..//div[text() = 'В корзину']"));
        addToCartBtn.click();*/

        /*driver.get("https://www.ozon.ru/cart");
        Assert.assertNotNull(driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in Data-Driven" +
                " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                "TestNG']")), "the book was not added to Cart");*/

        crdp=new CartPage(driver).//инициируем драйвер
                openPage(); //открыли страницу, на выходе объект класса HomePage

        WebElement bookInCart=crdp.bookInCartItem();//возвращает элемент который найден

        Assert.assertNotNull(bookInCart); // проверяем что все что делали до на выходе дало элемент, который найден на странице Корзины


    }

    @Test(dependsOnMethods = {"addToCartScenario"})
    public void removeFromCartScenario() throws InterruptedException {
        /*WebElement removeFromCartBtn = driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in " +
                "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
                " Java, and TestNG']/../..//span[contains(.,'Удалить')]"));
        removeFromCartBtn.click();
        WebElement fromCartBtn = driver.findElement(By.xpath("//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
                "//div[@class='kxa6']"));
        fromCartBtn.click();*/

        crdp.removeFromCart();

        WebElement emptyCartElement=crdp.cartEmptyItem();//возвращает элемент который найде

        Assert.assertNotNull(emptyCartElement); // проверяем что все что делали до на выходе дало элемент, который найден на странице Корзины
    }
}
