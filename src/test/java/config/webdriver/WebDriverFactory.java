package config.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Factory for different types of drivers.
 * This can be controlled via command line parameter.
 */
public class WebDriverFactory {
    private WebDriverFactory() {}

    public static WebDriver getDriver(DriverType browser) {
        WebDriver driver = null;
        switch (browser) {
            case FIREFOX:
                driver = getFirefoxDriver();
                break;
            case CHROME:
                driver = getChromeDriver();
                break;
            case IE:
                driver = getInternetExplorerDriver();
                break;
        }
        //gecko bug
        //https://github.com/mozilla/geckodriver/issues/820
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getInternetExplorerDriver() {
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("ignoreZoomSetting", true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        caps.setCapability("requireWindowFocus", true);
        return new InternetExplorerDriver(caps);
    }
}
