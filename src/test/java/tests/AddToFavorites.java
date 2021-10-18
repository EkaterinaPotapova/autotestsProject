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
        //в клиентской части уже без new ProductDetailsPage, просто используем текущий Instance класса ProductDetailsPage.
        // Если Instance этого класса еще не создавался, то он автоматически будет создан
        productDetailsPage = ProductDetailsPage.getInstance(driver)
                .openPage()
                .addToFavorites();
        WebElement numberOfFavorites = productDetailsPage.numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Test(dependsOnMethods = {"addToFavoritesScenario"})
    public void checkFavoritesScenario() {
        myFavoritesPage = MyFavoritesPage.getInstance(driver)
                .openPage();
        WebElement bookInFavorites = myFavoritesPage.numberOfFavorites();
        Assert.assertNotNull(bookInFavorites);
    }
}
