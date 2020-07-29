package core.environment;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilProperties.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class MobileDriver {

    private static AppiumDriver driver;

    public static AppiumDriver prepareEmulator() throws java.net.MalformedURLException {

        java.io.File appDir = new java.io.File("apps");
        java.io.File app = new java.io.File(appDir, "facebook.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Config.getPropertyValue("platformName"));
        capabilities.setCapability("autoGrantPermissions", Config.getAndroidProperty("autoGrantPermissions"));
        capabilities.setCapability("unicodeKeyboard", Config.getAndroidProperty("unicodeKeyboard"));
        capabilities.setCapability("resetKeyboard", Config.getAndroidProperty("resetKeyboard"));
        capabilities.setCapability("deviceName", Config.getAndroidProperty("deviceName"));
        capabilities.setCapability("platformVersion", Config.getAndroidProperty("platformVersion"));
        capabilities.setCapability("automationName", Config.getAndroidProperty("automationName"));
        capabilities.setCapability("newCommandTimeout", Config.getAndroidProperty("newCommandTimeout"));
        capabilities.setCapability("appWaitActivity", Config.getAndroidProperty("appWaitActivity"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new java.net.URL(Config.getPropertyValue("urlToConnect")), capabilities);
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.quit();
                core.environment.AppiumServer.stopServer();
                driver = null;
            } catch (Exception e) {
                System.out.println(java.util.Arrays.toString(e.getStackTrace()));
            }
        }
    }


}
