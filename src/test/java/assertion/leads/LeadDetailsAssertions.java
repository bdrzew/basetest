package assertion.leads;

import assertion.common.Assertions;
import page.leads.LeadDetailsPage;

import static org.testng.Assert.assertEquals;

/**
 * Assertions for Leads Page
 */
public class LeadDetailsAssertions extends Assertions<LeadDetailsPage> {

    public LeadDetailsAssertions verifyStatus(String name) {
        assertEquals(page.getStatus().getText(), name,
            "Lead status displayed in lead details page is not as expected. ");
        return this;
    }
}
