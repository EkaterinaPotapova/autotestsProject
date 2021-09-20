package tests;

import model.Product;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.CartPage;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;
import service.ProductCreator;

public class SearchBookTest extends BaseTestClass {

    private SearchResultPage searchResultPageObject;
    private CartPage cartPageObject;

    @Test
    public void testScenario() {
        Product product = ProductCreator.WithBothParams(); //Создаем сущность продукта
        searchResultPageObject = new HomePage(driver)//инициируем драйвер
                .openPage() //открыли страницу, на выходе объект класса HomePage
                .seachBook(product.getSearchWord(), product.getProductName());//к объекту класса HomePage применяем seachBook, получаем объект
        // SearchResultPage в которые передаем драйвер и term. Собираем конструктором такой обект.
        WebElement book = searchResultPageObject.searchResult();// к объекту класса SearchResultPage применяем метод
        // seachResult, который возвращает объект типа WebElement
        Assert.assertNotNull(book); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице результатов поиска
    }

    @Test(dependsOnMethods = {"testScenario"})
    public void addToCartScenario() {
        searchResultPageObject.addToCart();
        cartPageObject = new CartPage(driver)//инициируем драйвер
                .openPage(); //открыли страницу, на выходе объект класса CartPage
        WebElement bookInCart = cartPageObject.bookInCartItem();//возвращает элемент который найден
        Assert.assertNotNull(bookInCart); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице Корзины
    }

    @Test(dependsOnMethods = {"addToCartScenario"})
    public void removeFromCartScenario() {
        cartPageObject.removeFromCart();
        WebElement emptyCartElement = cartPageObject.cartEmptyItem();//возвращает элемент который найден
        Assert.assertNotNull(emptyCartElement); // проверяем что все что делали до на выходе дало элемент,
        // который найден на странице Корзины
    }
}
