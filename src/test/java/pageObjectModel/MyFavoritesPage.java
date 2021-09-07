package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CustomWaitCondition;

public class MyFavoritesPage extends AbstractPage {

    private static final String MyFavoritesPAGE_URL="https://www.ozon.ru/my/favorites";

    @FindBy(xpath = "//span[text() = 'Selenium Framework Design in Data-Driven" +
            " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
            "TestNG']")
    private WebElement bookInMyFavorites;

    public MyFavoritesPage(WebDriver driver){//конструктор
        super(driver);
    }

    @Override
    public MyFavoritesPage openPage(){
        driver.get(MyFavoritesPAGE_URL);
        new WebDriverWait(driver,WAIT_TIME_SEC).until(CustomWaitCondition.returnDocumentCompleted());
        return this;//вернули текущее состояние объекта страницы
    }

    public WebElement numberOfFavorites(){
        return  bookInMyFavorites;
    }

}
