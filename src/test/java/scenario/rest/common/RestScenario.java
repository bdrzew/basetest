package scenario.rest.common;

import config.RestApi;

/**
 * Interface representing any rest scenario
 */
public interface RestScenario {
   RestApi run();
}
