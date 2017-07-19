package page.settings;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import page.settings.common.SettingsPage;

/**
 * Profile settings page
 */
@Getter
public class ProfileSettingsPage extends SettingsPage {
    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }
}
