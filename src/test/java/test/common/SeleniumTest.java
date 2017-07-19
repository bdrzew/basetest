package test.common;

import config.TestConfig;
import config.TestListener;
import config.webdriver.DriverType;
import config.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * Class representing any selenium based test
 */
@Listeners(TestListener.class)
public abstract class SeleniumTest {
    private WebDriver driver;
    private TestConfig testConfig;

    @BeforeClass(alwaysRun = true)
    public void classSetup() {
        driver = WebDriverFactory.getDriver(
            DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase()));
    }

    @AfterClass(alwaysRun = true)
    public void classTeardown() {
        driver.quit();
    }

    /**
     * Retrieves web driver for this test class
     * @return WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    protected TestConfig getConfig() {
        if(testConfig == null) {
            testConfig = new TestConfig();
        }
        return testConfig;
    }
}
