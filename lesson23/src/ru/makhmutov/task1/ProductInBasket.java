package ru.makhmutov.task1;

public class ProductInBasket {
    private String name;
    private int quantity;

    /**
     * This is constructor for the ProductInBasket class
     *
     * @param name     The product name
     * @param quantity The product quantity
     */
    public ProductInBasket(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * This is getter for the product name
     *
     * @return The product name
     */
    public String getName() {
        return name;
    }

    /**
     * This is setter for the product name
     *
     * @param name The product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is getter for the product quantity
     *
     * @return The product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This is setter for the product quantity
     *
     * @param quantity The product quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
