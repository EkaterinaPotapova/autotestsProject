package pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CartPage {

    @FindBy(how = How.XPATH, using = "//span[text() = 'Selenium Framework Design in Data-Driven" +
            " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
            "TestNG']")
    private SelenideElement bookInCartItem;

    @FindBy(how = How.XPATH, using = "//div[@class='g5c8 _2avF']")
    private SelenideElement newPopUp;

    @FindBy(how = How.XPATH, using = "//span[text() = 'Selenium Framework Design in " +
            "Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver," +
            " Java, and TestNG']/../..//span[contains(.,'Удалить')]")
    private SelenideElement removeFromCartBtn;

    @FindBy(how = How.XPATH, using = "//div[@qa-id='checkcart-confirm-modal-confirm-button']" +
            "//div[@class='kxa6']")
    private SelenideElement acceptRemoveFromCartBtn;

    @FindBy(how = How.XPATH, using = "//h1[contains(.,'Корзина пуста')]")
    private SelenideElement emptyCardElement;

    public SelenideElement bookInCartItem() {
        return bookInCartItem;
    }

    public CartPage removeFromCart() {
        newPopUp.click();
        removeFromCartBtn.click();
        acceptRemoveFromCartBtn.click();
        return this;//тут возвращаем страницу результатов поиска(текущее состояние )
        // до этого такой страницы не было, вот мы ее создани
    }

    public SelenideElement cartEmptyItem() {
        return emptyCardElement;
    }
}
