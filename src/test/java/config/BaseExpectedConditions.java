package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Base specific expected conditions
 */
public class BaseExpectedConditions {
    public static ExpectedCondition<WebElement> clickStaleElement(By by){
        return driver -> {
            try {
                WebElement element = driver.findElement(by);
                element.click();
                return element;
            } catch (WebDriverException expected) {
                return null;
            }
        };
    }
}
