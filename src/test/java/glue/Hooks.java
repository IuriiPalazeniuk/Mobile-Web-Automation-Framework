package glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    @Before
    public void prepareAndroidForAppium() {
    }


    @After
    public void tearDown() {
        if (System.getProperty("platformName").equals("Android")) {
            core.environment.MobileDriver.closeDriver();
        } else {
            core.environment.WebDriverChrome.closeDriver();
        }
    }
}
