package driver;

import java.util.Objects;

/*
 * Driver class handles the Driver Initialisation and Quit
 */

public class Driver {

    public static void initDriver(){
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver());
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
