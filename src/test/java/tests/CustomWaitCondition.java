package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomWaitCondition {

    public static ExpectedCondition<Boolean> jQueryAJAXsCompleted() {
        return new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                //Длем когда свойство Document.readyState станет complete
                // Это значит что страница загружена вместе с дополнительными ресурсами.
               // такой  из лекции : return (Boolean) ((JavascriptExecutor)driver).executeScript("return
                // (window.jQuery != null) && (jQuery.active === 0);"); не работает

            }
        };
    }
}
