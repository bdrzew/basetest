package page.settings.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.Page;
import page.settings.LeadsSettingsPage;

/**
 * Component representing settings menu
 */
@Getter
public class SettingsMenuComponent extends Page {
    @FindBy(css = ".leads")
    private WebElement leads;

    public SettingsMenuComponent(WebDriver driver) {
        super(driver);
    }

    public LeadsSettingsPage clickLeads() {
        leads.click();
        return new LeadsSettingsPage(driver);
    }

}
