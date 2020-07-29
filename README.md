# Automation test framework

**BDD automation test framework**  - contains mobile and web test. 

Table of contents
=================
   * [Key features](#key-features)
   * [Technologies and frameworks](#technologies-and-frameworks)
   * [Test scenario example](#test-scenario-example)
   * [Test step example](#test-step-example)   
   * [Test runner](#test-runner)
   * [Run options](#run-options)
   * [Prerequisites for Appium](#prerequisites-for-Appium)
   * [Report](#report)

## Key features
  * BDD (Cucumber framework) is used for readability and extensibility of tests

    
## Technologies and frameworks
 * Java programming language ([Java](https://www.java.com)) 
 * Cucumber BDD framework ([Cucumber](https://cucumber.io/docs))
 * Maven build tool ([Maven](https://maven.apache.org))
 * Appium mobile testing ([Appium](http://appium.io/))

## Test scenario example

```java
 Scenario: Log in to FaceBook and check count fo friends
    Given user enter credentials and tap on login
    When user switched to All friends page
    Then check results
```

## Test step example

```java
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
```

## Test runner

```java
@CucumberOptions(features = "src/test/java/features/LoginPage.feature",
        glue = "glue",
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@smoke")
public class FaceBook_Runner extends AbstractTestNGCucumberTests {
}
```

## Run options
 * Locally via IDE (To run separate scenario you need Cucumber Java plugin to be installed)
 * Parameters must be provided: 'platformName' - Android/Windows, expected count of friends - 'count', 'login', 'password'
 
```bash
   'mvn clean test mvn clean test -DplatformName="Android"' -Dcount="155" -Dlogin="some_login" -Dpassword="some_password"
   'mvn clean test' - will run all tests
```
## Prerequisites for Appium:
 * need to install node.js -> write path in Environment settings of your PC.
 * install appium : npm install -g appium
 * install npm install -g appium-doctor
 * download Android SDK -> write path in Environment settings of your PC.
 * install Android Studio.
 * open AVD Manager and create some Virtual Devices.
 * update deviceName and platformVersion in configsAndroid.properties 


## Report
 * Report is located in target/cucumber/index.html