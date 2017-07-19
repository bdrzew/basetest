package scenario.rest;

import config.RestApi;
import lombok.AllArgsConstructor;
import model.Lead;
import scenario.rest.common.RestScenario;

/**
 * Scenario for retrieving lead id based on provided model.
 * Id inside of model is updated
 */
@AllArgsConstructor
public class LeadsRetrieveIdScenario extends RestApi implements RestScenario {
    private Lead lead;

    public RestApi run() {
        lead.setId(api()
                .queryParam("first_name", lead.getFirstName())
                .queryParam("last_name", lead.getLastName())
            .when()
                .get("v2/leads")
            .then()
                .log().all()
                .statusCode(200)
            .extract()
                .jsonPath().getString("items[0].data.id"));
        return this;
    }
}
