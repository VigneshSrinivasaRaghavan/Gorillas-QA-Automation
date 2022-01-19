package tests;

import constants.TestStringConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;
import pages.MyCartPage;
import utils.AppInteractions;

/*
 * This test is to verify My Cart page
 * It verifies Item Name, Price, Default quantity & Item quantity Increase/Decrease
 */

public class MyCartTest extends BaseTest {
    HomePage homePage;
    ItemDetailsPage itemDetailsPage;
    MyCartPage myCartPage;


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
    public void verifyToOpenCartPage(){
        myCartPage = homePage.clickMyCart();

        String actualQuantity = myCartPage.getDefaultQuantity();
        String expectedQuantity = TestStringConstants.getMyCartDefaultQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }

    @Test(priority = 1)
    public void verifyInCartPageItemCanBeDeleted(){
        myCartPage.clickRemoveItemButton();
    }

    @Test(priority = 2)
    public void verifyInCartPageQuantityCanBeIncreased(){
        myCartPage.clickQuantityIncreaseButton(2);
        String actualPrice = myCartPage.getTotalPrice();
        String expectedPrice = "$62.62";
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test(priority = 3)
    public void verifyInCartPageQuantityCanBeDecreased(){
        myCartPage.clickQuantityDecreaseButton(2);
        String actualPrice = myCartPage.getTotalPrice();
        String expectedPrice = "$36.64";
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test(priority = 4)
    public void verifyItemDetailsPageOpenFromCartPage(){
        String firstItemName = myCartPage.getFirstItemName();
        itemDetailsPage = myCartPage.clickFirstItem();

        String actualItemName = itemDetailsPage.getItemName();
        Assert.assertEquals(actualItemName, firstItemName);
    }
}