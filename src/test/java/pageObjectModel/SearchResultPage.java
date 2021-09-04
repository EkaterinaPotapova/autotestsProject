package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends AbstractPage {

        private  String searchTerm;



        @FindBy(xpath = "(//span[text() = 'Selenium Framework Design in Data-Driven Testing. " +
                "Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, " +
                "Java, and TestNG'])[2]")
        private WebElement searchResultItem;

        @FindBy(xpath = "(//span[text() = 'Selenium Framework Design " +
                "in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver," +
                " AppiumDriver, Java, and TestNG'])[2]/../../..//div[text() = 'В корзину']")
        private WebElement addToCartBtn;



        public SearchResultPage(WebDriver driver, String searchTerm){//конструктор
                super(driver);//передаем объект driver в родительский класс
                this.searchTerm=searchTerm;

        }

        public WebElement seachResult(){
                return  searchResultItem;
        }



        public SearchResultPage addToCart(){

                addToCartBtn.click();
                return this;//возвращает текущий объект страницы


        }
        @Override
        public AbstractPage openPage(){
                throw new RuntimeException("Ошибка открытия страницы результатов поиска");

        }



/*
        //Подождать 5 секунд
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    //проверить что книжка нашлась
        Assert.assertNotNull(driver.findElement(By.xpath("(//span[text() = 'Selenium Framework Design in Data-Driven" +
                " Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and " +
                "TestNG'])[2]")), "the book was not found");
*/



}
