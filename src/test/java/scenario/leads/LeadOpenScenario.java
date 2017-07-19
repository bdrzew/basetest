package scenario.leads;

import lombok.AllArgsConstructor;
import model.Lead;
import page.common.BasePage;
import page.leads.LeadDetailsPage;
import scenario.common.Scenario;

/**
 * Scenario opens existing lead details page
 */
@AllArgsConstructor
public class LeadOpenScenario implements Scenario<BasePage, LeadDetailsPage> {
    private Lead lead;

    @Override
    public LeadDetailsPage run(BasePage entry) {
        return entry.getTopBar()
            .clickLeads()
            .clickLeadInList(lead.getLastName());
    }
}
