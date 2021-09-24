package tests;

import com.codeborne.selenide.SelenideElement;
import model.Product;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.CartPage;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;
import service.ProductCreator;

import static com.codeborne.selenide.Selenide.open;

public class SearchBookTest {

    private SearchResultPage searchResultPageObject;
    private CartPage cartPageObject;

    @Test
    public void testScenario() {
        Product product = ProductCreator.withBothParams(); //Создаем сущность продукта
        HomePage homePage = open("http://ozon.ru/", HomePage.class);
        searchResultPageObject = homePage.seachBook(product.getSearchWord(), product.getProductName());
        SelenideElement book = searchResultPageObject.searchResult();
        Assert.assertNotNull(book); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице результатов поиска
    }

    @Test(dependsOnMethods = {"testScenario"})
    public void addToCartScenario() {
        searchResultPageObject.addToCart();
        cartPageObject = open("http://ozon.ru/cart", CartPage.class);
        SelenideElement bookInCart = cartPageObject.bookInCartItem();//возвращает элемент который найден
        Assert.assertNotNull(bookInCart); // проверяем что все что делали до на выходе дало элемент, который найден на
        // странице Корзины
    }

    @Test(dependsOnMethods = {"addToCartScenario"})
    public void removeFromCartScenario() {
       /*Waiter thread=new Waiter();
        synchronized(thread) {
            try {
                thread.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/ //Оставлю пока для отладки
        cartPageObject.removeFromCart();
        SelenideElement emptyCartElement = cartPageObject.cartEmptyItem();//возвращает элемент который найден
        Assert.assertNotNull(emptyCartElement); // проверяем что все что делали до на выходе дало элемент,
        // который найден на странице Корзины
    }
}
