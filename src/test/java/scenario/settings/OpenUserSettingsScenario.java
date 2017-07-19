package scenario.settings;

import page.common.BasePage;
import page.settings.ProfileSettingsPage;
import scenario.common.Scenario;

/**
 * Open Settings scenario
 */
public class OpenUserSettingsScenario implements Scenario<BasePage, ProfileSettingsPage> {

    @Override
    public ProfileSettingsPage run(BasePage entry) {
        return entry.getTopBar()
            .openSettingsDropdown()
            .clickSettings();
    }
}
