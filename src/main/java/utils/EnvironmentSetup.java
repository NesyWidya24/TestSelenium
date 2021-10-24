package utils;

import controllers.BaseMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.util.Properties;

public class EnvironmentSetup extends BaseMethod {

    @Test
    public static void environmentSetup(){
        try {
            Properties properties = new Properties();
            properties.setProperty("Author", "Torche Indonesia");
            properties.setProperty("Browser", Browser);
            properties.setProperty("OS", OSName);
            properties.setProperty("OS Architecture", OSArchitecture);
            properties.setProperty("OS Bit", OSBit);
            properties.setProperty("Host IP Adsress", InetAddress.getLocalHost().getHostAddress());

            File file = new File("./src/main/resources/environment.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Environment Setup");
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
