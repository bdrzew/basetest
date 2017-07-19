package page.leads;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;

/**
 * Class represents lead details page
 */
@Getter
public class LeadDetailsPage extends BasePage{
    @FindBy(css = "#details .lead-status")
    private WebElement status;
    @FindBy(css = ".detail-edit")
    private WebElement edit;

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    public LeadListPage clickEdit() {
        edit.click();
        return new LeadListPage(driver);
    }
}
