package model;

public class Product {

    private String searchWord;
    private String productName;

    //конструктор
    public Product(String searchWord, String productName) {
        this.productName = productName;
        this.searchWord = searchWord;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
