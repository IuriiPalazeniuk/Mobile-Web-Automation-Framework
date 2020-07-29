package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/LoginPage.feature",
        glue = "glue",
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@smoke")
public class FaceBook_Runner extends AbstractTestNGCucumberTests {
}
