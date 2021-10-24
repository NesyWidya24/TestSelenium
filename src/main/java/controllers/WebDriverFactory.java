package controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class WebDriverFactory extends BrowserFactory {
    public static ThreadLocal<WebDriver> wd = new ThreadLocal<>();
    public static String browser;
    public static String url;

    @BeforeTest(alwaysRun = true)
    public void suiteSetup() {
        switch (Browser.toLowerCase()) {
            case "chrome":
            case "chrome_headless":
                WebDriverManager.chromedriver().setup();

            case "firefox":
            case "firefox_headless":
                WebDriverManager.firefoxdriver().arch64().setup();
                break;

            case "ie":
            case "internet explorer":
                WebDriverManager.iedriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
            default:
                throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
        }
    }

    @BeforeMethod
    public void beforeMethod() throws Exception{
        System.out.println("Browser: " + Browser);
        System.out.println("WebsiteURL: "+ WebsiteUrl);
        new WebDriverFactory();
        WebDriver driver = WebDriverFactory.createDriver();
        setWebDriver(driver);
    }

    public void setWebDriver(WebDriver driver){
        wd.set(driver);
    }

    public static WebDriver getWebDriver(){
        return wd.get();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception{
        Thread.sleep(2000);
        getWebDriver().quit();
    }
}
