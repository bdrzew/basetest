package page.leads;

import config.BaseExpectedConditions;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.common.BasePage;

import java.util.List;

/**
 * Main Page class
 */
@Getter
public class LeadListPage extends BasePage {
    public static final String LEAD_LIST_ITEM
        = "//*[@class='name-link'][contains(text(),'%s')]";
    @FindBy(css = ".lead-list-item")
    private List<WebElement> leadList;
    @FindBy(id = "leads-new")
    private WebElement addLead;
    @FindBy(css = ".remove")
    private WebElement remove;

    public LeadListPage(WebDriver driver) {
        this(driver, null);
    }
    public LeadListPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public LeadCreationPage clickAddLeadButton() {
        addLead.click();
        return new LeadCreationPage(driver);
    }

    public LeadDetailsPage clickLeadInList(String description) {
        waitUntil(p -> !leadList.isEmpty());
        waitUntil(BaseExpectedConditions.clickStaleElement(
            By.xpath(String.format(LEAD_LIST_ITEM, description))));
        return new LeadDetailsPage(driver);
    }

    public LeadCreationPage clickDeleteThisLead() {
        remove.click();
        return new LeadCreationPage(driver);
    }
}
