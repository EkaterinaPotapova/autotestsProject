package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.MyFavoritesPsge;
import pageObjectModel.ProductDetailsPage;

public class AddToFavorites extends BaseTestClass{

    private ProductDetailsPage productDetailsPage;
    private MyFavoritesPsge myFavoritesPsge;

    @Test
    public void addToFavoritesScenario()  {

        productDetailsPage=new ProductDetailsPage(driver)
                .openPage()
                .addToFavorites();
        WebElement numberOfFavorites = productDetailsPage.numberOfFavorites();
        Assert.assertNotNull(numberOfFavorites);
    }

    @Test(dependsOnMethods = {"addToFavoritesScenario"})
    public void chackFavoritesScenario()  {

        myFavoritesPsge=new MyFavoritesPsge(driver)
                .openPage();
        WebElement bookInFavorites = myFavoritesPsge.numberOfFavorites();
        Assert.assertNotNull(bookInFavorites);
    }
}
