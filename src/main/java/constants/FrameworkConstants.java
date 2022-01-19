package constants;


/*
 * This class holds the constants used across the Framework
 */

public final class FrameworkConstants {

    private FrameworkConstants(){
    }

    private static final int waitTime=10;
    private static final String resourcesPath = System.getProperty("user.dir")+"/src/test/resources";
    private static final String loginJsonData = resourcesPath + "/data/loginData.json";
    private static final String configFilePath = resourcesPath + "/config/config.properties";

    public static int getWaitTime(){
        return waitTime;
    }

    public static String getResourcesPath(){
        return resourcesPath;
    }

    public static String getLoginJsonData(){
        return loginJsonData;
    }

    public static String getConfigFilePath(){
        return configFilePath;
    }

}
