package utils;

import driver.DriverManager;
import io.appium.java_client.InteractsWithApps;

/*
 * AppInteractions class handles the launching and closing the application
 */

public class AppInteractions {
    public static void launchApp() {
        ((InteractsWithApps) DriverManager.getDriver()).launchApp();
    }

    public static void closeApp() {
        ((InteractsWithApps) DriverManager.getDriver()).closeApp();
    }
}
