package pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//input[@placeholder[contains(.,'Искать')]]")
    private SelenideElement searchField;

    public SearchResultPage seachBook(String term, String book) {
        searchField
                .setValue(term)
                .pressEnter();
        return page(SearchResultPage.class);//тут возвращаем страницу результатов поиска(текущее состояние )
        // до этого такой страницы не было, вот мы ее создани
    }
}
