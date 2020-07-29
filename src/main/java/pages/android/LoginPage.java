package pages.android;

import org.openqa.selenium.By;
import utilProperties.Config;


public class LoginPage extends pages.android.Page {

    private By facebook_mail_field = By.xpath("//*[@content-desc='Username']");
    private By facebook_pass_field = By.xpath("//*[@content-desc='Password']");
    private By log_in_button_facebook = By.xpath("//*[@content-desc='Login click']");
    private By not_now_button = By.xpath("//*[@text='Not Now']");

    public void loginSteps() {
        sendKeysIntoField(facebook_mail_field, System.getProperty("login"));
        sendKeysIntoField(facebook_pass_field, System.getProperty("password"));
        tapOnElement(log_in_button_facebook);
        tapOnElement(not_now_button);
    }



}
