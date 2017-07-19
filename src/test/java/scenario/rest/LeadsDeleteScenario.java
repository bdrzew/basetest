package scenario.rest;

import config.RestApi;
import lombok.AllArgsConstructor;
import model.Lead;
import scenario.rest.common.RestScenario;

/**
 * Scenario for removing given lead
 */
@AllArgsConstructor
public class LeadsDeleteScenario extends RestApi implements RestScenario {
    private Lead lead;

    public RestApi run() {
        api()
            .when()
                .delete("v2/leads/" + lead.getId())
            .then()
                .log().all()
                .statusCode(204);
        return this;
    }
}
