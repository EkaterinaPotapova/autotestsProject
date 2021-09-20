package service;

import model.Product;

public class ProductCreator {

    public static final String SEARCH_WORD = "selenium java";
    public static final String PRODUCT_NAME = "Selenium Framework Design in Data-Driven Testing. " +
            "Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG";

    //Здесь создаем объект класса Product с заданными значениями SEARCH_WORD,PRODUCT_NAME
    public static Product WithBothParams() {
        return new Product(SEARCH_WORD, PRODUCT_NAME);
    }
}

