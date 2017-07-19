package config;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Base specific expected conditions
 */
public class BaseExpectedConditions {
    public static ExpectedCondition<WebElement> staleElement(By by){
        return driver -> {
            try {
                return driver.findElement(by);
            } catch (StaleElementReferenceException expected) {
                return null;
            }
        };
    }
}
