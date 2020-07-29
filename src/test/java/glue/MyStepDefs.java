package glue;


import core.environment.WebDriverChrome;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.android.AllFriedsPage;
import pages.android.LoginPage;
import pages.android.MainPage;
import utilProperties.Config;


public class MyStepDefs {

    @Given("^user enter credentials and tap on login$")
    public void userEnterCredentialsAndTapOnLogin() {
        if (System.getProperty("platformName").contains("Windows")) {
            WebDriverChrome.getWebDriver().get(Config.getPropertyValue("url"));
            pages.webWindows.LoginPage login = new pages.webWindows.LoginPage(WebDriverChrome.getWebDriver());
            login.logIn();

        } else {
           LoginPage logInPage = new LoginPage();
            logInPage.loginSteps();
        }
    }

    @When("^user switched to All friends page$")
    public void userSwitchedToAllFriendsPage() {
        if (System.getProperty("platformName").contains("Windows")) {
            pages.webWindows.MainPage main = new pages.webWindows.MainPage(WebDriverChrome.getWebDriver());
            main.switchToAllFriedsPage();

        } else {
           MainPage mainPage = new MainPage();
            mainPage.switchToAllFriendsPage();
        }
    }

    @Then("^check results$")
    public void checkResults() {
        String expectedCount = System.getProperty("count");
        if (System.getProperty("platformName").contains("Windows")) {
            pages.webWindows.FriedsPage page = new pages.webWindows.FriedsPage(WebDriverChrome.getWebDriver());
            page.checkCount(Integer.parseInt(expectedCount));
        } else {
            AllFriedsPage friends = new AllFriedsPage();
            friends.checkCount(Integer.parseInt(expectedCount));
        }
    }
}
