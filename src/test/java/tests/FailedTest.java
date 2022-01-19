package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;
import utils.AppInteractions;

/*
 * This test is written to fail as to show the screenshot in the report
 */

public class FailedTest extends BaseTest {
    HomePage homePage;
    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void beforeClass(){
        AppInteractions.closeApp();
        AppInteractions.launchApp();
    }

    @BeforeMethod
    public void beforeMethod() {
        homePage = new HomePage();
    }

    @Test(priority = 0)
    public void failedTestToDisplayScreenshot(){
        itemDetailsPage = homePage.clickFirstItem();

        String actualItemPrice = itemDetailsPage.getItemPrice();
        String expectedItemPrice = "$10.99";
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }
}