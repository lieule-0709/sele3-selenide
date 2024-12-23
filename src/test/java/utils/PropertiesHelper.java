package utils;

import enums.PropKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static Properties properties = null;
    private static final String TEST_PROPERTIES_FILE = System.getProperty("user.dir").concat("/src/test/resources/test.properties");

    private static Properties getProperties(String path) {
        try {
            System.out.println("\nLoading properties from " + path);
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            System.out.println("\nError loading properties from " + path);
        }
        return null;
    }

    public static String getProperty(PropKey key, String defaultValue) {
        if(System.getProperty(key.getKey()) != null && !System.getProperty(key.getKey()).isEmpty()) {
            return System.getProperty(key.getKey()).trim();
        }
        if(properties == null) {
            properties = getProperties(TEST_PROPERTIES_FILE);
        }
        if(properties != null && properties.containsKey(key.getKey())) {
            return properties.getProperty(key.getKey()).trim();
        }
        return defaultValue;
    }

    public static String getProperty(PropKey key) {
        return getProperty(key, null);
    }

}
