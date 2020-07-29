package pages.webWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilProperties.Config;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "u_0_b")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(){
        emailInput.sendKeys(System.getProperty("login"));
        passwordInput.sendKeys(System.getProperty("password"));
        submitButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
