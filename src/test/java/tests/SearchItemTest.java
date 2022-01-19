package tests;

import constants.TestStringConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemDetailsPage;
import pages.SearchPage;
import utils.AppInteractions;

/*
 * This test is to verify the Search page
 * It verifies item can be searched with given text
 */

public class SearchItemTest extends BaseTest {
    HomePage homePage;
    ItemDetailsPage itemDetailsPage;
    SearchPage searchPage;

    String itemToSearch = "Cupcake";

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
    public void verifyToSearchItem(){
        searchPage = homePage.clickSearchBar();
        Assert.assertTrue(searchPage.searchBarIsDisplayed());

        String searchResultCount = searchPage.enterTextInSearchBar(itemToSearch).getSearchResultCount();

        Assert.assertEquals(searchResultCount,"1 items");
    }

    @Test(priority = 1)
    public void verifyClickSearchResultOpensItemDetailsPage(){
        itemDetailsPage = searchPage.clickFirstSearchResult();
        String actualItemName = itemDetailsPage.getItemName();
        Assert.assertEquals(actualItemName, itemToSearch);

        String actualItemPrice = itemDetailsPage.getItemPrice();
        String expectedItemPrice = TestStringConstants.getCupCakeItemPrice();
        Assert.assertEquals(actualItemPrice, expectedItemPrice);
    }

}