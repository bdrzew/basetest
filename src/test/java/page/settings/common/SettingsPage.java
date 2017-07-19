package page.settings.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import page.common.BasePage;

/**
 * Class representing any settings page
 */
@Getter
public abstract class SettingsPage extends BasePage {
    private final SettingsMenuComponent menu;

    public SettingsPage(WebDriver driver) {
        super(driver);
        menu = new SettingsMenuComponent(driver);
    }
}
