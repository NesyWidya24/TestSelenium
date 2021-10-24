package controllers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.File;

public class InitMethod {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String WebsiteUrl = appConfig.getWebsiteUrl();
    public static String Browser = appConfig.getBrowser();
    public static int MaxPageLoadTime = appConfig.getMaxPageLoadTime();
    public static int ImplicitlyWait = appConfig.getImplicitlyWait();
    public static String VideoFeature = appConfig.getVideoFeature();

    public static String FS = File.separator;

    public static String OSName = System.getProperty("os.name");
    public static String OSArchitecture = System.getProperty("os.arch");
    public static String OSVersion = System.getProperty("os.version");
    public static String OSBit = System.getProperty("sun.arch.data.model");

    public static String ProjectWorkingDirectory = System.getProperty("user.dir");

    public static String ExcelFiles = ".src/test/resources/Excel Files/";

    public static Robot robot;
    public static Alert alert;
    public static Select select;
    public static Actions actions;
}
