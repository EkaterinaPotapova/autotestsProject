package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.CustomWaitCondition;

public class CartPage extends AbstractPage{

    private static final String CART_URL="http://ozon.ru/cart";

    @FindBy(xpath = "//span[text() = 'Selenium Framework Design in Data-Driven" +
            " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
            "TestNG']")
    private WebElement bookInCartItem;

    @FindBy(xpath = "//span[text() = 'Selenium Framework Design in " +
            "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
            " Java, and TestNG']/../..//span[contains(.,'Удалить')]")
    private WebElement removeFromCartBtn;

    @FindBy(xpath = "//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
            "//div[@class='kxa6']")
    private WebElement acceptRemoveFromCartBtn;

    @FindBy(xpath = "//h1[contains(.,'Корзина пуста')]")
    private WebElement emptyCardElement;


    public CartPage(WebDriver driver) {//конструктор
        super(driver);
    }


    @Override
    public CartPage openPage(){
        driver.get(CART_URL);
        new WebDriverWait(driver,WAIT_TIME_SEC).until(CustomWaitCondition.returnDocumentCompleted());
        // WebElement until = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated((By) searchField));
        return this;//вернули текущее состояние объекта страницы


    }

    public WebElement bookInCartItem(){
        return  bookInCartItem;
    }

    public CartPage removeFromCart(){
        removeFromCartBtn.click();
        acceptRemoveFromCartBtn.click();

        return  this;//тут возвращаем страницу результатов поиска(текущее состояние )
        // до этого такой страницы не было, вот мы ее создани

    }
    public WebElement cartEmptyItem(){
        return  emptyCardElement;
    }
    /*Assert.assertNotNull(driver.findElement(By.xpath("//h1[contains(.,'Корзина пуста')]")), "the book " +
            "was not removed from Cart");*/

/*
    WebElement removeFromCartBtn = driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in " +
            "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
            " Java, and TestNG']/../..//span[contains(.,'Удалить')]"));
        removeFromCartBtn.click();
    WebElement fromCartBtn = driver.findElement(By.xpath("//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
            "//div[@class='kxa6']"));
        fromCartBtn.click();*/
/*
     driver.get("https://www.ozon.ru/cart");
        Assert.assertNotNull(driver.findElement(By.xpath("//span[text() = 'Selenium Framework Design in Data-Driven" +
                " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                "TestNG']")), "the book was not added to Cart");*/
}
