package pages.webWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FriedsPage extends pages.webWindows.BasePage {


    private String friendsTable = "//div[@class='i1fnvgqd lhclo0ds btwxx1t3 j83agx80']";
    private String listOfFriends = "./div[@class='bp9cbjyn ue3kfks5 pw54ja7n uo3d90p7 l82x9zwi n1f8r23x rq0escxv j83agx80 bi6gxh9e discj3wi hv4rvrfc ihqw7lf3 dati1w0a gfomwglr']";

    public FriedsPage(WebDriver driver) {
        super(driver);
    }

    public int countAllFriends() {
        for (int second = 0; ; second++) {
            if (second >= 30) {
                break;
            }
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,800)", "");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        List<WebElement> elem = driver.findElement(By.xpath(friendsTable)).findElements(By.xpath(listOfFriends));
        return elem.size();
    }

    public void checkCount(int expectedCount){
        Assert.assertEquals(expectedCount, countAllFriends(), "WebBrowser shows wrong count of friends");
    }
}
