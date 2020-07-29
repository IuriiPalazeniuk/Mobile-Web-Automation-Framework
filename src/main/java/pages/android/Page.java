package pages.android;


import core.environment.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {

    protected AppiumDriver driver = (AppiumDriver) DriverFactory.getDriver("Android");

    public void tapOnElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        driver.findElement(element).click();

    }

    protected boolean isElementPresent(By by) {
        boolean result = false;
        try {
            result = driver.findElements(by).size() > 0;
        } catch (NoSuchElementException ex) {
            System.out.println("Element is not present!");
        }
        return result;
    }

    public void sendKeysIntoField(By element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(text);
    }

    public void swiptToBottom() {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int width = size.width / 2;
        int startPoint = (int) (size.getHeight() * 0.80);
        int endPoint = (int) (size.getHeight() * 0.30);

        new io.appium.java_client.TouchAction(driver).press(io.appium.java_client.touch.offset.PointOption.point(width, startPoint))
                .waitAction(io.appium.java_client.touch.WaitOptions.waitOptions(java.time.Duration.ofMillis(2000)))
                .moveTo(io.appium.java_client.touch.offset.PointOption.point(width, endPoint)).release().perform();

    }

    public void swipeToElement(By element) {
        while (!isElementPresent(element)) {
            swiptToBottom();
        }
    }

}


