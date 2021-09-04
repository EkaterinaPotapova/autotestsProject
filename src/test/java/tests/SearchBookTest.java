package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.CartPage;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;

public class SearchBookTest extends BaseTestClass {

    private SearchResultPage searchResultPageObject;
    private CartPage cartPageOblect;


    @Test
    public void testScenario()  {
        searchResultPageObject =new HomePage(driver).//инициируем драйвер
                openPage(). //открыли страницу, на выходе объект класса HomePage
                seachBook("selenium java");//к объекту класса HomePage применяем seachBook, получаем объект
        // SearchResultPage в которые передаем драйвер и term. Собираем конструктором такой обект.
        WebElement book = searchResultPageObject.seachResult();// к объекту класса SearchResultPage применяем метод
        // seachResult, который возвращает объект типа WebElement
        Assert.assertNotNull(book); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице результатов поиска
    }

    @Test(dependsOnMethods = {"testScenario"})
    public void addToCartScenario() {
        searchResultPageObject.addToCart();
        cartPageOblect =new CartPage(driver).//инициируем драйвер
                openPage(); //открыли страницу, на выходе объект класса HomePage
        WebElement bookInCart= cartPageOblect.bookInCartItem();//возвращает элемент который найден
        Assert.assertNotNull(bookInCart); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице Корзины
    }

    @Test(dependsOnMethods = {"addToCartScenario"})
    public void removeFromCartScenario() {
        cartPageOblect.removeFromCart();
        WebElement emptyCartElement= cartPageOblect.cartEmptyItem();//возвращает элемент который найде
        Assert.assertNotNull(emptyCartElement); // проверяем что все что делали до на выходе дало элемент,
        // который найден на странице Корзины
    }
}
