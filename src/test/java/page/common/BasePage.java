package page.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

/**
 * Abstract Pge object representing any GetBase page
 */
@Getter
public abstract class BasePage extends Page {
    private final TopBarComponent topBar;

    public BasePage(WebDriver driver) {
        this(driver, null);
    }

    public BasePage(WebDriver driver, String url) {
        super(driver, url);
        topBar = new TopBarComponent(driver);
    }
}
