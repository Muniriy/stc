package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class BasketImplementation implements Basket {
    private static final Logger log = LogManager.getLogger(BasketImplementation.class);
    private final List<String> productNamesList = new LinkedList<>();
    private final List<ProductInBasket> productInBasketList = new LinkedList<>();

    /**
     * This method allows to add product to the basket
     *
     * @param product  The product name
     * @param quantity The product quantity
     */
    @Override
    public void addProduct(String product, int quantity) {
        if (quantity > 0) {
            ProductInBasket productInBasket = new ProductInBasket(product, quantity);
            if (productNamesList.contains(product)) {
                updateProductQuantity(product, getProductQuantity(product) + quantity);
            } else {
                productNamesList.add(product);
                productInBasketList.add(productInBasket);
            }
            log.info("{} item(s) of {} was/were added to the basket", quantity, product);
        } else {
            log.error("Quantity cannot be less than 1");
            System.exit(2);
        }
    }

    /**
     * This method allows to remove product from the basket
     *
     * @param product The product name
     */
    @Override
    public void removeProduct(String product) {
        if (productNamesList.contains(product)) {
            int productIndex = productNamesList.indexOf(product);
            productInBasketList.remove(productIndex);
            productNamesList.remove(productIndex);
            log.info("The {} was fully removed from the basket", product);
        } else {
            log.error("Deletion of non-existent product");
            System.exit(1);
        }
    }

    /**
     * This product allows to update the quantity of the product
     * in the basket
     *
     * @param product  The product name
     * @param quantity The product quantity
     */
    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (productNamesList.contains(product)) {
            int productIndex = productNamesList.indexOf(product);
            productInBasketList.get(productIndex).setQuantity(quantity);
        } else {
            log.error("Non-existent product quantity is updated");
            System.exit(1);
        }
    }

    /**
     * This method allows to clear the basket
     */
    @Override
    public void clear() {
        productInBasketList.clear();
        productNamesList.clear();
        log.info("The basket was released");
    }

    /**
     * This method allows to get all the List of products
     * lying in the basket
     *
     * @return The list of product names lying in the basket
     */
    @Override
    public List<String> getProducts() {
        return productNamesList;
    }

    /**
     * This method allows to get the quantity of the product
     * from the basket
     *
     * @param product The product name
     * @return The product quantity
     */
    @Override
    public int getProductQuantity(String product) {
        if (productNamesList.contains(product)) {
            int productIndex = productNamesList.indexOf(product);
            return productInBasketList.get(productIndex).getQuantity();
        } else {
            log.error("Non-existent product quantity is checked");
            System.exit(1);
            return -1;
        }
    }
}
