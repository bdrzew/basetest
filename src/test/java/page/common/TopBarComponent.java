package page.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.leads.LeadListPage;

/**
 * Component representing top menu bar
 */
@Getter
public class TopBarComponent extends Page {
    @FindBy(id = "user-dd")
    private WebElement userDropdown;
    @FindBy(id = "nav-leads")
    private WebElement leads;

    public TopBarComponent(WebDriver driver) {
        super(driver);
    }

    public UserSettingsDropdownComponent openSettingsDropdown() {
        userDropdown.click();
        return new UserSettingsDropdownComponent(driver);
    }

    public LeadListPage clickLeads() {
        leads.click();
        return new LeadListPage(driver);
    }
}
