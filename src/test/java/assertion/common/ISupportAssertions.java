package assertion.common;

import page.common.Page;

/**
 * Page needs to implement this to be able to perform assertions
 */
public interface ISupportAssertions {

    <G extends Page, T extends Assertions<G>> T check(Class<T> clazz) throws RuntimeException;

}
