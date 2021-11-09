package pageObjectModel;

import myReporting.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import sIngleton.WebDriverSingleton;
import tests.CustomWaitCondition;
import utils.MyUtil;

public class MyFavoritesPage extends AbstractPage {
    private static MyFavoritesPage instance;

    private static final String MyFavoritesPAGE_URL = "https://www.ozon.ru/my/favorites";

    @FindBy(xpath = "//span[text() = 'Selenium Framework Design in Data-Driven" +
            " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
            "TestNG']")
    private WebElement bookInMyFavorites;

    //конструктор private
    private MyFavoritesPage(WebDriver driver) {//конструктор
        super(driver);
    }

    //проверяем был ли instance класса ProductDetailsPage уже создан.
    // Еслим не был то создаем новый ProductDetailsPage(driver) объект
    public static MyFavoritesPage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new MyFavoritesPage(driver);
            MyLogger.info("instance of MyFavoritesPage created");
        }
        return instance;
    }

    @Override
    public MyFavoritesPage openPage() {
        WebDriverSingleton.getInstance().get(MyFavoritesPAGE_URL);
        new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_TIME_SEC).until(CustomWaitCondition.returnDocumentCompleted());
        MyLogger.info("Open MyFavoritesPage on URL " + MyFavoritesPAGE_URL);
        return this;//вернули текущее состояние объекта страницы
    }

    public WebElement numberOfFavorites() {
        MyUtil.highlightElement(WebDriverSingleton.getInstance(), bookInMyFavorites);
        MyLogger.info("Element bookInMyFavorites found with xpath = //span[text() = 'Selenium Framework Design in Data-Driven...");
        return bookInMyFavorites;
    }
}
