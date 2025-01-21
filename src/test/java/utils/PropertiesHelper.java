package utils;

import enums.PropKey;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {
    private static Properties properties;
    private static final String TEST_PROPERTIES_FILE = System.getProperty("user.dir").concat("/src/test/resources/test.properties");


    public PropertiesHelper() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(TEST_PROPERTIES_FILE)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file: " + TEST_PROPERTIES_FILE, e);
        }
        properties = props;
    }

    public static String getProperty(PropKey key, String defaultValue) {
        if(System.getProperty(key.getKey()) != null && !System.getProperty(key.getKey()).isEmpty()) {
            return System.getProperty(key.getKey()).trim();
        }
        if(properties.containsKey(key.getKey())) {
            return properties.getProperty(key.getKey()).trim();
        }
        return defaultValue;
    }

    public static String getProperty(PropKey key) {
        return getProperty(key, null);
    }

}
