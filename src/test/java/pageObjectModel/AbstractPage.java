package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIME_SEC=1000;

    protected AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
