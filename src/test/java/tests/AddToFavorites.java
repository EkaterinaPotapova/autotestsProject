package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.MyFavoritesPage;
import pageObjectModel.ProductDetailsPage;

public class AddToFavorites extends BaseTestClass {

    private ProductDetailsPage productDetailsPage;
    private MyFavoritesPage myFavoritesPage;

    @Test
    public void addToFavoritesScenario() {
        productDetailsPage = new ProductDetailsPage(driver)
                .openPage()
                .addToFavorites();
        WebElement numberOfFavorites = productDetailsPage.numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Test(dependsOnMethods = {"addToFavoritesScenario"})
    public void checkFavoritesScenario() {
        myFavoritesPage = new MyFavoritesPage(driver)
                .openPage();
        WebElement bookInFavorites = myFavoritesPage.numberOfFavorites();
        Assert.assertNotNull(bookInFavorites);
    }
}
