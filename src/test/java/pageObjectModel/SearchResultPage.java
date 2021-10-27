package pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static service.ProductCreator.PRODUCT_NAME;

public class SearchResultPage {

    @FindBy(how = How.XPATH, using = "(//span[text() = '" + PRODUCT_NAME + "'])")
    private SelenideElement searchResultItem;

    @FindBy(how = How.XPATH, using = "(//span[text() = '" + PRODUCT_NAME + "'])/../../..//div[text() = 'В корзину']")
    private SelenideElement addToCartBtn;

    public SelenideElement searchResult() {
        return searchResultItem;
    }

    public SearchResultPage addToCart() {
        addToCartBtn.click();
        return this;//возвращает текущий объект страницы
    }


}
