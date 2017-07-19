package page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.common.BasePage;
import page.dashboard.DashboardPage;

/**
 * Login Page class
 */
@Getter
public class LoginPage extends BasePage {
    @FindBy(id = "user_email")
    private WebElement emailField;
    @FindBy(id = "user_password")
    private WebElement passwordField;
    @FindBy(css = ".btn-primary")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this(driver, null);
    }
    public LoginPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public LoginPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public DashboardPage clickLogin() {
        loginButton.click();
        return new DashboardPage(driver);
    }
}
