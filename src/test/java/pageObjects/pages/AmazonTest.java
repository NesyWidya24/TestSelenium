package pageObjects.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;

import static utils.ExplicitWaiting.explicitWaitVisibilityOfElement;

public class AmazonTest extends PageFactoryInitializer {
    //reproduce
    @FindBy(css = "#nav-hamburger-menu")
    private WebElement navigationMenu;
    @FindBy(css = ".hmenu-visible > :nth-child(7) > .hmenu-item")
    private WebElement electronicMenu;
    @FindBy(css = ".hmenu-visible > :nth-child(15) > .hmenu-item")
    private WebElement televisionVideoMenu;
    @FindBy(css = "#n\\/172659 > span > a")
    private WebElement televisionMenu;
    @FindBy(css = "#p_n_size_browse-bin\\/1232879011 > .a-list-item > .a-link-normal > .a-size-base")
    private WebElement filterScreenSize;
    @FindBy(css = "#a-autoid-2-announce")
    private WebElement sortBy;
    @FindBy(css = "#s-result-sort-select_1")
    private WebElement sortByLow;
    @FindBy(css = "#s-result-sort-select_2")
    private WebElement sortByHigh;


    @Step("Reproduce")
    public AmazonTest reproduceAmazonTest() throws InterruptedException {
        explicitWaitVisibilityOfElement(navigationMenu, 10000);
        Thread.sleep(5000);
        click(navigationMenu);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(electronicMenu, 10000);
        click(electronicMenu);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(televisionVideoMenu, 10000);
        click(televisionVideoMenu);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(televisionMenu, 10000);
        click(televisionMenu);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(filterScreenSize, 10000);
        click(filterScreenSize);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(sortBy, 10000);
        click(sortBy);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(sortByLow, 10000);
        click(sortByLow);
        Thread.sleep(5000);
        explicitWaitVisibilityOfElement(sortByHigh, 10000);
        click(sortByHigh);
        Thread.sleep(5000);
        return this;
    }
}
