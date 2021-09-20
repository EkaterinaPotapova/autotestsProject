package pageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CustomWaitCondition;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "http://ozon.ru/";

    @FindBy(xpath = "//input[@placeholder[contains(.,'Искать')]]")
    private WebElement searchField;

    @FindBy(css = "[aria-label=Поиск]")
    private WebElement searchBtn;

    public HomePage(WebDriver driver) {//конструктор
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIME_SEC).until(CustomWaitCondition.returnDocumentCompleted());
        return this;//вернули текущее состояние объекта страницы
    }

    public SearchResultPage seachBook(String term, String book) {
        searchField.sendKeys(term);

        new Actions(driver).sendKeys(searchBtn, Keys.RETURN).build().perform();
        //Нажимаем Enter

        //searchBtn.click();
        return new SearchResultPage(driver, term, book);//тут возвращаем страницу результатов поиска(текущее состояние )
        // до этого такой страницы не было, вот мы ее создани
    }
}
