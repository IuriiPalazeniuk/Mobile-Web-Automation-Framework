package pages.android;

import org.openqa.selenium.By;

public class MainPage extends pages.android.Page {

    private By menu = By.xpath("//android.view.View[4]");
    private By your_profile = By.xpath("//*[@content-desc='Your Profile']");
    private By friends = By.xpath("//*[@content-desc='See All Friends']");

    public void switchToAllFriendsPage() {
        tapOnElement(menu);
        tapOnElement(your_profile);
        swipeToElement(friends);
        tapOnElement(friends);
        driver.findElement(By.xpath("//*[@content-desc='Find Friends']/.."));
    }

}
