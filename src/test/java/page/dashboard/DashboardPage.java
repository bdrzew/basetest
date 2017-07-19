package page.dashboard;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import page.common.BasePage;

/**
 * Main Page class
 */
@Getter
public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        this(driver, null);
    }
    public DashboardPage(WebDriver driver, String url) {
        super(driver, url);
    }
}
