package tests;

import driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.AppiumServer;

/*
  * Base Test runs before every test
  * Base test handles to automatically start and stop the Appium Server
  * Base test initialise and de-initialise the Driver
 */

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        AppiumServer.startServer();
    }

    @AfterSuite
    public void afterSuite() {
        AppiumServer.stopServer();
    }

    @BeforeTest()
    public void beforeTest() {
        Driver.initDriver();
    }

    @AfterTest()
    public void afterTest() {
        Driver.quitDriver();
    }
}
