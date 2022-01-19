package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.Scroll;

/*
 * This class contains the locators of the My Cart Page
 */

public class MyCartPage extends BasePage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]") private MobileElement defaultQuantity;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Increase\"])[1]") private MobileElement quantityIncreaseButton;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Decrease\"])[2]") private MobileElement quantityDecreaseButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.Button") private MobileElement itemRemove;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[10]") private MobileElement totalPrice;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]") private MobileElement firstItemName;
    private String totalText = "Total";


    public MyCartPage clickQuantityIncreaseButton(int quantity){
        for (int i = 0; i < quantity; i++) {
            click(quantityIncreaseButton,"Quantity Increase Button");
        }
        return this;
    }

    public MyCartPage clickQuantityDecreaseButton(int quantity){
        for (int i = 0; i < quantity; i++) {
            click(quantityDecreaseButton,"Quantity Decrease Button");
        }
        return this;
    }

    public String getTotalPrice(){
        Scroll.scrollToElement("text",totalText);
        return getAttribute(totalPrice, "text");
    }

    public String getDefaultQuantity(){
        return getAttribute(defaultQuantity,"text");
    }

    public MyCartPage clickRemoveItemButton(){
        click(itemRemove,"Item Remove");
        return this;
    }

    public String getFirstItemName(){
        return getAttribute(firstItemName,"text");
    }

    public ItemDetailsPage clickFirstItem(){
        click(firstItemName,"First Item");
        return new ItemDetailsPage();
    }

}


