package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import decorator.CustomDriverDecorator;
import factoryMethod.WebDriverCreator;
import factoryMethod.WebDriverGH;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjectModel.HomePage;
import pageObjectModel.MyFavoritesPage;
import pageObjectModel.ProductDetailsPage;
import pageObjectModel.SearchResultPage;
import service.ProductCreator;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class OzonStepDefinitions {
    protected WebDriver driver;
    private WebDriverWait wait10;
    private int stringLenght;
    private HomePage homePage;
    private Product product;
    private SearchResultPage searchResultPageObject;

    @Before
    public void driverUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverCreator creator = new WebDriverGH();
        driver = creator.createWebDriver();
        driver = new CustomDriverDecorator(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Таймаут на загрузку страниц, выбросит NoSuchElementException если в течение 10 секунд элемент не будет найден
        wait10 = new WebDriverWait(driver, 10);
        stringLenght = 10;
        product = ProductCreator.withBothParams();
    }

    @Given("I opened Product Details Page")
    public void iOpenedProductDetailsPage(){
        ProductDetailsPage.getInstance(driver)
                .openPage();

    }
    @When("I click Add To Favorites Button")
    public void iClickAddToFavoritesButton(){
        ProductDetailsPage.getInstance(driver).addToFavorites();

    }



    @Then("I see Number Of Favorites")
    public void iSeeNumberOfFavorites(){
        WebElement numberOfFavorites = ProductDetailsPage.getInstance(driver).numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Given("I opened My Favorites Page")
    public void iOpenMyFavoritesPage(){
        MyFavoritesPage.getInstance(driver)
                .openPage();
    }
    @Then("I see Book In Favorites")
    public void iSeeBookInFavorites(){
        WebElement bookInFavorites = MyFavoritesPage.getInstance(driver).numberOfFavorites();
        Assert.assertNotNull(bookInFavorites);
    }
    @Given("I opened Home Page")
    public void iOpenedHomePage(){
        homePage = open("http://ozon.ru/", HomePage.class);
    }
    @When("I Search book")
    public void iSearchBook(){
        searchResultPageObject = homePage.seachBook(product.getSearchWord(), product.getProductName());
    }

    @Then("I see Book Search result page")
    public void iSeeBookSearchResultPage(){
        homePage.seachBook(product.getSearchWord(), product.getProductName());
        SelenideElement book = searchResultPageObject.searchResult();
        Assert.assertNotNull(book);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }
}
