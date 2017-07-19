package config;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.specification.RequestSpecification;
import scenario.rest.common.RestScenario;

/**
 * Class representing rest api configuration
 */
public class RestApi {

    protected RequestSpecification api() {
        return RestAssured
            .given()
                .baseUri(PropertiesManager.getProperties("testconfig").getProperty("api.url"))
                .auth().oauth2(PropertiesManager.getProperties("testconfig").getProperty("api.key"), OAuthSignature.HEADER)
                .accept("application/json")
            .log()
                .all();
    }

    public RestApi run(RestScenario scenario) {
        return scenario.run();
    }
}
