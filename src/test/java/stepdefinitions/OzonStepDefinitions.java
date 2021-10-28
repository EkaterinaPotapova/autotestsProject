package stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjectModel.HomePage;
import pageObjectModel.MyFavoritesPage;
import pageObjectModel.ProductDetailsPage;
import pageObjectModel.SearchResultPage;
import sIngleton.WebDriverSingleton;


import static com.codeborne.selenide.Selenide.open;

public class OzonStepDefinitions {

    private HomePage homePage;
    private SearchResultPage searchResultPageObject;

    @Given("I opened Product Details Page")
    public void iOpenedProductDetailsPage() {
        ProductDetailsPage.getInstance(WebDriverSingleton.getInstance())
                .openPage();
    }

    @When("I click Add To Favorites Button")
    public void iClickAddToFavoritesButton() {
        ProductDetailsPage.getInstance(WebDriverSingleton.getInstance()).addToFavorites();
    }

    @Then("I see Number Of Favorites")
    public void iSeeNumberOfFavorites() {
        WebElement numberOfFavorites = ProductDetailsPage.getInstance(WebDriverSingleton.getInstance()).numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Given("I opened My Favorites Page")
    public void iOpenMyFavoritesPage() {
        MyFavoritesPage.getInstance(WebDriverSingleton.getInstance())
                .openPage();
    }

    @Then("I see Book In Favorites")
    public void iSeeBookInFavorites() {
        WebElement bookInFavorites = MyFavoritesPage.getInstance(WebDriverSingleton.getInstance()).numberOfFavorites();
        //тут очень удобно синглтон getInstance(driver)
        Assert.assertNotNull(bookInFavorites);
    }

    @Given("I opened Home Page")
    public void iOpenedHomePage() {
        homePage = open("http://ozon.ru/", HomePage.class);
    }

    @When("I Search book with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSearchBook(String searchWord, String searchBook) {
        searchResultPageObject = homePage.seachBook(searchWord, searchBook);
        //здесь нет синглтона, приходится носить searchResultPageObject
    }

    @Then("I see Book Search result page")
    public void iSeeBookSearchResultPage() {
        SelenideElement book = searchResultPageObject.searchResult();
        Assert.assertNotNull(book);
        WebDriverSingleton.getInstance().navigate().refresh();//Чтобы поле поиска обновилось перед следующим параметром
    }
}
