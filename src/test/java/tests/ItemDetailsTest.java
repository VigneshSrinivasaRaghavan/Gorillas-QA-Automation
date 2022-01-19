package tests;

import constants.TestStringConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;
import utils.AppInteractions;

/*
 * This test is to verify the Item Details page
 * It verifies Item Name, Price, Default  quantity & Item quantity Increase/Decrease
 */

public class ItemDetailsTest extends BaseTest {
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
    public void verifyItemDetailsPageDisplaysValidNameAndPrice(){
        String firstItemName = homePage.getFirstItemName();
        itemDetailsPage = homePage.clickFirstItem();

        String actualItemName = itemDetailsPage.getItemName();
        Assert.assertEquals(actualItemName, firstItemName);

        String actualItemPrice = itemDetailsPage.getItemPrice();
        String expectedItemPrice = TestStringConstants.getCupCakeItemPrice();
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }

    @Test(priority = 1)
    public void verifyItemDetailsPageDisplaysDefaultQuantity(){
        String actualItemQuantity = itemDetailsPage.getQuantity();
        String expectedItemQuantity = TestStringConstants.getDefaultQuantity();
        Assert.assertEquals(actualItemQuantity, expectedItemQuantity);
    }

    @Test(priority = 2)
    public void verifyInItemDetailsPageQuantityCanBeIncreased(){
        itemDetailsPage.clickQuantityIncreaseButton(2);

        String actualItemQuantity = itemDetailsPage.getQuantity();
        String expectedItemQuantity = "3";
        Assert.assertEquals(actualItemQuantity, expectedItemQuantity);
    }

    @Test(priority = 3)
    public void verifyInItemDetailsPageQuantityCanBeDecreased(){
        itemDetailsPage.clickQuantityDecreaseButton(2);

        String actualItemQuantity = itemDetailsPage.getQuantity();
        String expectedItemQuantity = TestStringConstants.getDefaultQuantity();
        Assert.assertEquals(actualItemQuantity, expectedItemQuantity);
    }
}