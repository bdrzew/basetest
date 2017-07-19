package assertion.common;

import page.common.Page;

/**
 * Abstract assertions class
 * @param <T> Page or component class which assertions should be testing
 */
public abstract class Assertions<T extends Page> {

    protected T page;

    public T endAssertion() {
        return page;
    }

    public void setPage(T page) {
        this.page = page;
    }
}
