package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*
 * This class contains the locators of the Search Page
 */

public class SearchPage extends BasePage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText") private MobileElement searchBar;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]") private MobileElement searchResultCount;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]/android.view.View") private MobileElement firstSearchResult;


    public boolean searchBarIsDisplayed(){
        return elementIsDisplayed(searchBar);
    }

    public SearchPage enterTextInSearchBar(String text){
        sendKeys(searchBar,text,"Search Bar");
        return this;
    }

    public String getSearchResultCount(){
        return getAttribute(searchResultCount,"text");
    }

    public ItemDetailsPage clickFirstSearchResult(){
        click(firstSearchResult,"First Search Result");
        return new ItemDetailsPage();
    }
}


