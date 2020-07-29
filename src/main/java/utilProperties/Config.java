package utilProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static String pathToAndroidConfigFile = "configsAndroid.properties";
    private static String pathToConfigFile = "configs.properties";


    public static String getAndroidProperty (String key){
        return getPropertyFile(pathToAndroidConfigFile).getProperty(key);
    }

    private static Properties getPropertyFile(String pathToConfigFile) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToConfigFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    public static String getPropertyValue(String key) {
        return getPropertyFile(pathToConfigFile).getProperty(key);
    }


}
