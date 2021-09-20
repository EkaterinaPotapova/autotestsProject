package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static service.ProductCreator.PRODUCT_NAME;

public class SearchResultPage extends AbstractPage {

    private final String searchTerm;
    private String searchBook;

    @FindBy(xpath = "(//span[text() = '" + PRODUCT_NAME + "'])[2]")
    private WebElement searchResultItem;

    @FindBy(xpath = "(//span[text() = '" + PRODUCT_NAME + "'])[2]/../../..//div[text() = 'В корзину']")
    private WebElement addToCartBtn;

    public SearchResultPage(WebDriver driver, String searchTerm, String searchBook) {//конструктор
        super(driver);//передаем объект driver в родительский класс
        this.searchTerm = searchTerm;
        this.searchBook = searchBook;
    }

    public WebElement searchResult() {
        return searchResultItem;
    }

    public SearchResultPage addToCart() {
        new Actions(driver).moveToElement(addToCartBtn).build().perform();
        //Двигаем мышку на элемент
        new Actions(driver).click().build().perform();
        //Кликаем мышкой в текущей позиции
        return this;//возвращает текущий объект страницы
    }

    @Override
    public AbstractPage openPage() {
        throw new RuntimeException("Ошибка открытия страницы результатов поиска");
    }
}
