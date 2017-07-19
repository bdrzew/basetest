package page.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.LoginPage;
import page.settings.ProfileSettingsPage;

/**
 * Class representing user settings dropdown in top bar
 */
@Getter
public class UserSettingsDropdownComponent extends Page {
    @FindBy(css = ".dropdown-menu .settings")
    private WebElement userDropdownSettings;
    @FindBy(css = ".dropdown-menu .icon-signout")
    private WebElement userDropdownLogout;

    public UserSettingsDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public ProfileSettingsPage clickSettings() {
        userDropdownSettings.click();
        return new ProfileSettingsPage(driver);
    }

    public LoginPage clickLogout() {
        userDropdownLogout.click();
        return new LoginPage(driver);
    }
}
