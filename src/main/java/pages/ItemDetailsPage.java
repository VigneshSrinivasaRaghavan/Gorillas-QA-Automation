package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/*
 * This class contains the locators of the Item Details Page
 */

public class ItemDetailsPage extends BasePage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]") private MobileElement itemName;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]") private MobileElement itemPrice;
    @AndroidFindBy(accessibility = "Increase") private MobileElement quantityIncreaseButton;
    @AndroidFindBy(accessibility = "Decrease") private MobileElement quantityDecreaseButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[7]") private MobileElement quantity;

    public String getItemName(){
        return getAttribute(itemName,"text");
    }

    public String getItemPrice(){
        return getAttribute(itemPrice,"text");
    }

    public ItemDetailsPage clickQuantityIncreaseButton(int quantity){
        for (int i = 0; i < quantity; i++) {
            click(quantityIncreaseButton,"Quantity Increase Button");
        }
        return this;
    }

    public ItemDetailsPage clickQuantityDecreaseButton(int quantity){
        for (int i = 0; i < quantity; i++) {
            click(quantityDecreaseButton,"Quantity Decrease Button");
        }
        return this;
    }

    public String getQuantity(){
        return getAttribute(quantity,"text");
    }

}


