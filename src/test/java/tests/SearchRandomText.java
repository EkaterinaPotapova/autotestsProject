package tests;

import model.Product;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.SearchResultPage;
import service.ProductCreator;
import utils.StringUtil;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchRandomText {

    private SearchResultPage searchResultPageObject;
    private int stringLenght = 10;

    @Test
    public void testScenario() {
        Product product = ProductCreator.withBothParams(); //Создаем сущность продукта
        product.setSearchWord(StringUtil.generateRandomString(stringLenght)); //устанавливаем значения полей
        product.setProductName(StringUtil.generateRandomString(stringLenght));
        HomePage homePage = open("http://ozon.ru/", HomePage.class);
        searchResultPageObject = homePage.seachBook(product.getSearchWord(), product.getProductName());
        Assert.assertFalse($(By.xpath("(//span[text() = '" + product.getSearchWord() + "'])")).exists()); // проверяем что если поисковый запрос некорректный, то элемент не будет найден
    }
}
