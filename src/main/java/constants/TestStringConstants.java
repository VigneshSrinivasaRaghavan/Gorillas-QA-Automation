package constants;

/*
 * This class holds the constants used in the test for assertions
 */

public final class TestStringConstants {

    private TestStringConstants(){
    }

    private static final String cupCakeItemName="Cupcake";
    private static final String cupCakeItemPrice="$2.99";
    private static final String defaultQuantity="1";
    private static final String myCartDefaultQuantity="Order (3 items)";

    public static String getCupCakeItemName() {
        return cupCakeItemName;
    }

    public static String getCupCakeItemPrice() {
        return cupCakeItemPrice;
    }

    public static String getDefaultQuantity() {
        return defaultQuantity;
    }

    public static String getMyCartDefaultQuantity() {
        return myCartDefaultQuantity;
    }
}
