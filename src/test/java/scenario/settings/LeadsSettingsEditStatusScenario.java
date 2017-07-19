package scenario.settings;

import lombok.AllArgsConstructor;
import model.settings.LeadStatus;
import page.settings.LeadsSettingsPage;
import page.settings.common.SettingsPage;
import scenario.common.Scenario;

/**
 * Scenario representing editing lead status in Leads settings
 */
@AllArgsConstructor
public class LeadsSettingsEditStatusScenario implements Scenario<SettingsPage, LeadsSettingsPage> {
    LeadStatus status;

    @Override
    public LeadsSettingsPage run(SettingsPage entry) {
        return entry.getMenu()
            .clickLeads()
            .selectLeadStatusesTab()
            .clickEditButtonOfStatus(status.getIndex())
            .setStatusName(status.getName())
            .clickSave();
    }
}
