package page.settings;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.settings.common.SettingsPage;

import java.util.List;

/**
 * Leads settings page
 */
@Getter
public class LeadsSettingsPage extends SettingsPage {
    @FindBy(xpath = "//*[@data-toggle='lead-status']")
    private WebElement statusesTab;
    @FindBy(css = "#lead-status button.edit")
    private List<WebElement> editButtons;
    @FindBy(css = "#lead-status .form input#name")
    private WebElement nameInput;
    @FindBy(css = "#lead-status .form button.save")
    private WebElement save;

    public LeadsSettingsPage(WebDriver driver) {
        super(driver);
    }

    public LeadsSettingsPage selectLeadStatusesTab() {
        statusesTab.click();
        return this;
    }

    public LeadsSettingsPage clickEditButtonOfStatus(int index) {
        waitUntil(p -> !editButtons.isEmpty());
        editButtons.get(index).click();
        return this;
    }

    public LeadsSettingsPage setStatusName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
        return this;
    }

    public LeadsSettingsPage clickSave() {
        save.click();
        return this;
    }
}
