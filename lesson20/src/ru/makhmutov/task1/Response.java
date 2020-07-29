package ru.makhmutov.task1;

public class Response {
    private String product;
    private int init;
    private Dataseries[] dataseries;

    /**
     * This is the getter for the product name
     *
     * @return The time product
     */
    public String getProduct() {
        return product;
    }

    /**
     * This is the setter for the product name
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * This is the getter for the initializing id
     *
     * @return The initializing id
     */
    public int getInit() {
        return init;
    }

    /**
     * This is the getter for the initializing id
     */
    public void setInit(int init) {
        this.init = init;
    }

    /**
     * This is the getter for the dataseries array
     *
     * @return The dataseries array
     */
    public Dataseries[] getDataseries() {
        return dataseries;
    }

    /**
     * This is the getter for the dataseries array
     */
    public void setDataseries(Dataseries[] dataseries) {
        this.dataseries = dataseries;
    }
}
