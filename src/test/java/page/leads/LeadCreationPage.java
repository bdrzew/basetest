package page.leads;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.common.BasePage;

/**
 * Class represents lead creation page
 */
@Getter
public class LeadCreationPage extends BasePage{
    @FindBy(id = "lead-first-name")
    private WebElement firstNameField;
    @FindBy(id = "lead-last-name")
    private WebElement lastNameField;
    @FindBy(css = ".save")
    private WebElement save;
    @FindBy(css = ".btn-danger.confirm")
    private WebElement confirmRemoval;

    public LeadCreationPage(WebDriver driver) {
        super(driver);
    }

    public LeadCreationPage setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        return this;
    }

    public LeadCreationPage setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        return this;
    }

    public LeadDetailsPage clickSave() {
        save.click();
        return new LeadDetailsPage(driver);
    }

    public LeadListPage confirmRemoveInPopup() {
        waitUntil(ExpectedConditions.elementToBeClickable(confirmRemoval));
        confirmRemoval.click();
        return new LeadListPage(driver);
    }
}
