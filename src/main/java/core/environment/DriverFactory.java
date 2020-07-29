package core.environment;

import org.openqa.selenium.WebDriver;

import static core.environment.MobileDriver.prepareEmulator;
import static core.environment.WebDriverChrome.getWebDriver;
import static core.environment.emulator.Emulator.emulateDevice;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String platformName) {
        if (driver == null) {
            try {
                switch (platformName) {
                    case "Android":
                        AppiumServer.startServer();
                        emulateDevice();
                        driver = prepareEmulator();
                        break;
                    case "Windows":
                        driver = getWebDriver();
                        break;
                    default:
                        System.out.println("Invalid platform name");
                        break;
                }
            } catch (java.net.MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
