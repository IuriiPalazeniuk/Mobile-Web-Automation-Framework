package pages.webWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends pages.webWindows.BasePage {

    @FindBy(xpath = "//div[@class='j83agx80 fv0vnmcu fop5sh7t']")
    private WebElement your_profile;

    @FindBy(xpath = "//div[@class='l9j0dhe7 stjgntxs ni8dbmo4']/a")
    private WebElement friedsButton;

    @FindBy(xpath = "(//span[@class='oi732d6d ik7dh3pa d2edcug0 qv66sw1b c1et5uql a5q79mjw g1cxx5fr knj5qynh q66pz984 a8c37x1j ni8dbmo4 stjgntxs ltmttdrg g0qnabr5'])[2]")
    private WebElement seeAllButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void switchToAllFriedsPage() {
        waitAndClick(your_profile);
        scrollToElement(friedsButton);
        waitAndClick(seeAllButton);
    }
}
