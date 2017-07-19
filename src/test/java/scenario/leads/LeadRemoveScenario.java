package scenario.leads;

import lombok.AllArgsConstructor;
import model.Lead;
import page.common.BasePage;
import page.leads.LeadListPage;
import scenario.common.Scenario;

/**
 * Remove lead scenario
 */
@AllArgsConstructor
public class LeadRemoveScenario implements Scenario<BasePage, LeadListPage> {
    private Lead lead;

    @Override
    public LeadListPage run(BasePage entry) {
        return entry.getTopBar()
            .clickLeads()
            .run(new LeadOpenScenario(lead))
            .clickEdit()
            .clickDeleteThisLead()
            .confirmRemoveInPopup();
    }
}
