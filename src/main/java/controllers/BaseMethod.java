package controllers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import utils.EnvironmentSetup;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class BaseMethod extends WebDriverFactory{
    @AfterTest
    public void beforeSuite() throws Exception {
        EnvironmentSetup.environmentSetup();
    }

    public String getUrlTitle() throws Exception{
        URL aURL = new URL(WebsiteUrl);
        String WebName = aURL.getHost();
        return WebName.toUpperCase();
    }

    public void hitEnter() throws Exception{
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void hitArrowDown() throws Exception{
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
    }

    public void hitBackspace() throws Exception{
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
    }

    public void hitDelete() throws Exception{
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }

    public void selectAll() throws Exception{
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
    }

    /* To Paste all the Selected Text/Web Elements using ROBOT */
    public void pasteAll() throws Exception
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }


    /* To Capture Screenshot(Replaces if already exists) */
    /*
     * Also, Make sure that the automation in running in the foreground to
     * capture the Image of the Browser. Else, It'll capture the open Window
     */
    public void robotScreenCapture(String robotImageName) throws Exception
    {
        robot = new Robot();
        Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage bufferedImage = robot.createScreenCapture(area);
        // Save as PNG
        File file = new File(robotImageName);
        if (file.exists())
        {
            file.delete();
        }
        ImageIO.write(bufferedImage, "png", file);
    }


    /* To ZoomOut */
    public void robotZoomOut() throws Exception
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }


    /* To ZoomIn */
    public void robotZoomIn() throws Exception
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ADD);
        robot.keyRelease(KeyEvent.VK_ADD);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }


    /* To ScrollUp using ROBOT */
    public void robotScrollUp() throws Exception
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
    }


    /* To ScrollDown using ROBOT */
    public void robotScrollDown() throws Exception
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
    }


    /* To ScrollUp using JavaScript Executor */
    public void scrollUp() {
        ((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, -100);");
    }


    /* To ScrollDown using JavaScript Executor */
    public void scrollDown() {
        ((JavascriptExecutor) getWebDriver()).executeScript("scroll(0, 100);");
    }


    /* To Move cursor to the Desired Location */
    public void moveCursor(int X_Position, int Y_Position) {
        robot.mouseMove(X_Position, Y_Position);
    }


    /* To Accept the Alert Dialog Message */
    public void alertAccept() {
        alert = getWebDriver().switchTo().alert();
        alert.accept();
    }


    /* To Dismiss the Alert Dialog Message */
    public void alertDismiss() {
        alert = getWebDriver().switchTo().alert();
        alert.dismiss();
    }


    /* To Get the Alert Messages */
    public String getAlertText() throws Exception
    {
        alert = getWebDriver().switchTo().alert();
        String text = alert.getText();
        Thread.sleep(2000);
        alertAccept();
        return text;
    }


    /* To Upload a File using JAVA AWT ROBOT */
    public void fileUpload(String FileToUpload) throws Exception
    {
        Thread.sleep(5000);
        StringSelection filetocopy = new StringSelection(FileToUpload);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filetocopy, null);
        Thread.sleep(1000);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    /* To Perform a WebAction of Mouse Over */
    public void mousehover(WebElement element)
    {
        actions = new Actions(getWebDriver());
        actions.moveToElement(element).build().perform();
    }


    /* To Perform Select Option by Visible Text */
    public void selectByVisibleText(WebElement element, String value)
    {
        select = new Select(element);
        select.selectByVisibleText(value);
    }


    /* To Perform Select Option by Index */
    public void selectByIndex(WebElement element, int value)
    {
        select = new Select(element);
        select.selectByIndex(value);
    }


    /* To Perform Select Option by Value */
    public void selectByValue(WebElement element, String value)
    {
        select = new Select(element);
        select.selectByValue(value);
    }


    /* To click a certain Web Element */
    public void click(WebElement element)
    {
        element.click();
    }


    /* To click a certain Web Element using DOM/ JavaScript Executor */
    public void JSclick(WebElement element)
    {
        ((JavascriptExecutor) getWebDriver()).executeScript("return arguments[0].click();", element);
    }


    /* To Type at the specified location */
    public void sendKeys(WebElement element, String value)
    {
        element.sendKeys(value);
    }


    /* To Clear the content in the input location */
    public void clear(WebElement element)
    {
        element.clear();
    }


    /* To Drag and Drop from Source Locator to Destination Locator */
    public void dragandDrop(WebElement Source, WebElement Destination)
    {
        actions = new Actions(getWebDriver());
        actions.dragAndDrop(Source, Destination);
    }


    /*To Drag from the given WebElement Location and Drop at the given WebElement location */
    public void dragandDropTo(WebElement Source, int XOffset, int YOffset) {
        actions = new Actions(getWebDriver());
        actions.dragAndDropBy(Source, XOffset, YOffset);
    }


    /*To Open a Page in New Tab */
    public void rightClick(WebElement element)
    {
        actions = new Actions(getWebDriver());
        actions.contextClick(element);
        actions.build().perform();
    }


    /*To Close Current Tab */
    public void closeCurrentTab()
    {
        getWebDriver().close();
    }


    /*To Perform Click and Hold Action */
    public void clickAndHold(WebElement element)
    {
        actions = new Actions(getWebDriver());
        actions.clickAndHold(element);
        actions.build().perform();
    }


    /*To Perform Click and Hold Action */
    public void doubleClick(WebElement element)
    {
        actions = new Actions(getWebDriver());
        actions.doubleClick(element);
        actions.build().perform();
    }


    /*To Switch To Frame By Index */
    public void switchToFrameByIndex(int index) {
        getWebDriver().switchTo().frame(index);
    }


    /*To Switch To Frame By Frame Name */
    public void switchToFrameByFrameName(String frameName) {
        getWebDriver().switchTo().frame(frameName);
    }


    /*To Switch To Frame By Web Element */
    public void switchToFrameByWebElement(WebElement element) {
        getWebDriver().switchTo().frame(element);
    }


    /*To Switch out of a Frame */
    public void switchOutOfFrame() {
        getWebDriver().switchTo().defaultContent();
    }


    /*To Get Tooltip Text */
    public String getTooltipText(WebElement element)
    {
        return element.getAttribute("title").trim();
    }


    /*To Close all Tabs/Windows except the First Tab */
    public void closeAllTabsExceptFirst()
    {
        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        for(int i=1;i<tabs.size();i++)
        {
            getWebDriver().switchTo().window(tabs.get(i));
            getWebDriver().close();
        }
        getWebDriver().switchTo().window(tabs.get(0));
    }


    /*To Print all the Windows */
    public void printAllTheWindows()
    {
        ArrayList<String> al = new ArrayList<>(getWebDriver().getWindowHandles());
        for(String window : al)
        {
            System.out.println(window);
        }
    }
}
