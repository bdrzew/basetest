package scenario.leads;

import lombok.AllArgsConstructor;
import model.Lead;
import page.common.BasePage;
import page.leads.LeadDetailsPage;
import scenario.common.Scenario;

/**
 * Scenario for creating new lead
 */
@AllArgsConstructor
public class LeadCreateScenario implements Scenario<BasePage, LeadDetailsPage> {
    private Lead lead;

    @Override
    public LeadDetailsPage run(BasePage entry) {
        return entry.getTopBar()
            .clickLeads()
            .clickAddLeadButton()
            .setFirstName(lead.getFirstName())
            .setLastName(lead.getLastName())
            .clickSave();
    }
}
