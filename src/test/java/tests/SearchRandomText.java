package tests;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;
import service.ProductCreator;
import utils.StringUtil;

public class SearchRandomText extends BaseTestClass {

    private SearchResultPage searchResultPageObject;

    @Test
    public void testScenario() {
        Product product = ProductCreator.WithBothParams(); //Создаем сущность продукта
        product.setSearchWord(StringUtil.generateRandomString(stringLenght)); //устанавливаем значения полей
        product.setProductName(StringUtil.generateRandomString(stringLenght));

        searchResultPageObject = new HomePage(driver)//инициируем драйвер
                .openPage() //открыли страницу, на выходе объект класса HomePage
                .seachBook(product.getSearchWord(), product.getProductName());//к объекту класса HomePage применяем
        // seachBook, получаем объект SearchResultPage .
        WebElement book;
        try {
            book = driver.findElement(By.xpath("(//span[text() = '" + product.getSearchWord() + "'])"));
        } catch (NoSuchElementException notFound) {
            book = null;
        }
        Assert.assertNull(book); // проверяем что если поисковый запрос некорректный, то элемент не будет найден
    }

}
