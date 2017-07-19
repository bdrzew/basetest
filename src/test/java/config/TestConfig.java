package config;

/**
 * Test configurations
 */
public class TestConfig {

    public String getBaseUrl() {
        return PropertiesManager.getProperties("testconfig").getProperty("base.url");
    }
}
