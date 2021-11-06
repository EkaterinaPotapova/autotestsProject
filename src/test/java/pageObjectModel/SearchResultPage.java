package pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import myReporting.MyLogger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import sIngleton.WebDriverSingleton;
import utils.MyUtil;

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
        MyUtil.HighlightElement(WebDriverSingleton.getInstance(),addToCartBtn);
        addToCartBtn.click();
        MyLogger.info("Click addToCartBtn on SearchResultPage");
        return this;//возвращает текущий объект страницы
    }
}
