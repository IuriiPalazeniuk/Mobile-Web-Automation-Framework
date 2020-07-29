package core.environment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class WebDriverChrome {


    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(java.util.Arrays.asList("--allow-running-insecure-content", "--ignore-certificate-errors", "--disable-notifications",
                    "--disable-popup-blocking", "--disable-dev-shm-usage", "--no-sandbox", "--disable-gpu",
                    "--test-type"));
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }

}
