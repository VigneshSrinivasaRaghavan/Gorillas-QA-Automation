package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*
 * This class contains the locators of the Home Page
 */

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[1]") private MobileElement firstItem;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[1]") private MobileElement firstItemName;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]") private MobileElement searchBar;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]") private MobileElement myCart;


    public ItemDetailsPage clickFirstItem(){
        click(firstItem,"First Item");
        return new ItemDetailsPage();
    }

    public String getFirstItemName(){
        return getAttribute(firstItemName,"text");
    }

    public SearchPage clickSearchBar(){
        click(searchBar,"Search Bar");
        return new SearchPage();
    }

    public MyCartPage clickMyCart(){
        click(myCart,"My Cart");
        return new MyCartPage();
    }

}


