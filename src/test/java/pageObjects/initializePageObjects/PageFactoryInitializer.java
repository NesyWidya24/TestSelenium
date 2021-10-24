package pageObjects.initializePageObjects;

import controllers.BaseMethod;
import org.openqa.selenium.support.PageFactory;
import pageObjects.pages.AmazonTest;

public class PageFactoryInitializer extends BaseMethod {
    public AmazonTest amazonTestPageObject(){
        return PageFactory.initElements(getWebDriver(), AmazonTest.class);
    }
}
