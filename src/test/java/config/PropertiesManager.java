package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties manager to read given property file
 */
public class PropertiesManager {
    private static Map<String, Properties> propertiesMap= new HashMap<>();
    private PropertiesManager() {}

    public static Properties getProperties(String fileName) {
        if(propertiesMap.containsKey(fileName)) {
            return propertiesMap.get(fileName);
        }
        Properties prop = new Properties();
        try (InputStream input = PropertiesManager.class.getClassLoader()
                .getResourceAsStream( fileName + ".properties")){
            prop.load(input);
            propertiesMap.put(fileName, prop);
            return prop;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
