package scenario;

import lombok.AllArgsConstructor;
import model.BaseUser;
import page.LoginPage;
import page.dashboard.DashboardPage;
import scenario.common.Scenario;

/**
 * Login scenario
 */
@AllArgsConstructor
public class LoginScenario implements Scenario<LoginPage, DashboardPage> {
    private BaseUser user;

    @Override
    public DashboardPage run(LoginPage loginPage) {
        return loginPage
            .setEmail(user.getEmail())
            .setPassword(user.getPassword())
            .clickLogin();
    }

}
