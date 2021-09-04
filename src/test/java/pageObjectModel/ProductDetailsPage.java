package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.CustomWaitCondition;

public class ProductDetailsPage extends AbstractPage{

    private static final String PDPPAGE_URL="https://www.ozon.ru/product/selenium-framework-design-in-data-driven" +
            "-testing-157550235/?asb=hSh80VhTZYNWPWQ7v69WFyTSHalpwseOZM5%252FLv3JG%252FQ%253D&asb2=MGfvgKaB-" +
            "46wMMf1nODUyGVGKvbH1hC7K9cNsws6SlY&keywords=selenium+java";

    @FindBy(xpath = "//*[text() ='В избранное']")
    private WebElement addToFavoritesBtn;

    @FindBy(xpath = "//*[@href='/my/favorites']/*[text() ='1']")
    private WebElement numberOfFavorites;




    public ProductDetailsPage(WebDriver driver){//конструктор
        super(driver);
    }

    @Override
    public ProductDetailsPage openPage(){
        driver.get(PDPPAGE_URL);
        new WebDriverWait(driver,WAIT_TIME_SEC).until(CustomWaitCondition.returnDocumentCompleted());
        return this;//вернули текущее состояние объекта страницы
    }

    public ProductDetailsPage addToFavorites(){
        addToFavoritesBtn.click();
        return  this;//тут возвращаем страницу деталей продукта (текущее состояние )
    }

    public WebElement numberOfFavorites(){
        return  numberOfFavorites;
    }


}