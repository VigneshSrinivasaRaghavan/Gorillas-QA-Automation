package driver;

import io.appium.java_client.AppiumDriver;

/*
 * Driver Manager class handles Driver instance with Thread Safety
 * This helps to achieve running test in parallel
 */

public class DriverManager {

    private DriverManager(){
    }

    private static ThreadLocal<AppiumDriver> dr = new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return dr.get();
    }

    static void setDriver(AppiumDriver driverReference){
        dr.set(driverReference);
    }

    static void unload(){
        dr.remove();
    }
}
