package scenario;

import page.LoginPage;
import page.common.BasePage;
import scenario.common.Scenario;

/**
 * Logout Scenario
 */
public class LogoutScenario implements Scenario<BasePage, LoginPage> {
    @Override
    public LoginPage run(BasePage entry) {
        return entry.getTopBar()
            .openSettingsDropdown()
            .clickLogout();
    }
}
