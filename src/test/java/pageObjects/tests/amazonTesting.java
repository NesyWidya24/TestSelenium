package pageObjects.tests;

import controllers.ExcelDataProvider;
import io.qameta.allure.Description;
import listeners.AllureListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.initializePageObjects.PageFactoryInitializer;

@Listeners({AllureListener.class})
public class amazonTesting extends PageFactoryInitializer {
    @Description("Amazon Testing")
    @Test
    public void testAmazon() throws Exception {
        amazonTestPageObject()
                .reproduceAmazonTest();
    }
}
