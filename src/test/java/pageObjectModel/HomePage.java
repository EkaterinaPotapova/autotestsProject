package pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import myReporting.MyLogger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import sIngleton.WebDriverSingleton;
import utils.MyUtil;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//input[@placeholder[contains(.,'Искать')]]")
    private SelenideElement searchField;

    public SearchResultPage seachBook(String term, String book) {
        MyUtil.highlightElement(WebDriverSingleton.getInstance(), searchField);
        searchField
                .setValue(term)
                .pressEnter();

        MyLogger.debug("Press Enter with value " + term);
        return page(SearchResultPage.class);//тут возвращаем страницу результатов поиска(текущее состояние )
        // до этого такой страницы не было, вот мы ее создани
    }
}
