package test;

import assertion.leads.LeadDetailsAssertions;
import config.RestApi;
import model.BaseUser;
import model.Lead;
import model.settings.LeadStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import scenario.LoginScenario;
import scenario.LogoutScenario;
import scenario.leads.LeadCreateScenario;
import scenario.leads.LeadOpenScenario;
import scenario.rest.LeadsDeleteScenario;
import scenario.rest.LeadsRetrieveIdScenario;
import scenario.settings.LeadsSettingsEditStatusScenario;
import scenario.settings.OpenUserSettingsScenario;
import test.common.SeleniumTest;

/**
 * This test class verifies some basic scenarios inside of Base web application
 */
public class BaseTest extends SeleniumTest {
    private BaseUser user;
    private LeadStatus newStatus, modifiedStatus;
    private Lead lead;

    @BeforeMethod(alwaysRun = true)
    public void testSetup() {
        user = BaseUser.builder()
            .email("pupu@papa.pl").password("pupupapa")
            .build();
        newStatus = LeadStatus.builder()
            .index(0).name("New")
            .build();
        modifiedStatus = LeadStatus.builder()
            .index(0).name("Modified")
            .build();
        lead = Lead.builder()
            .firstName("leadname").lastName("leadsurname")
            .build();

        new LoginPage(getDriver(), getConfig().getBaseUrl())
            .run(new LoginScenario(user))
            .run(new OpenUserSettingsScenario())
            .run(new LeadsSettingsEditStatusScenario(newStatus))
            .run(new LogoutScenario());
    }

    @Test
    public void verifyInterviewScenarioTest() {
        new LoginPage(getDriver(), getConfig().getBaseUrl())
            .run(new LoginScenario(user))
            .run(new LeadCreateScenario(lead))
                .check(LeadDetailsAssertions.class)
                    .verifyStatus(newStatus.getName())
                .endAssertion()
            .run(new OpenUserSettingsScenario())
            .run(new LeadsSettingsEditStatusScenario(modifiedStatus))
            .run(new LeadOpenScenario(lead))
                .check(LeadDetailsAssertions.class)
                    .verifyStatus(modifiedStatus.getName())
                .endAssertion()
            .run(new LogoutScenario());
    }

    @AfterMethod(alwaysRun = true)
    public void testTeardown() {
        new RestApi()
            .run(new LeadsRetrieveIdScenario(lead))
            .run(new LeadsDeleteScenario(lead));
    }
}
