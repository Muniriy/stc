package ru.makhmutov.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketImpl implements Basket {
    private static final Logger log = LogManager.getLogger(BasketImpl.class);
    private final Map<String, Integer> productMap = new HashMap<>();

    /**
     * This method allows to add product to the basket
     *
     * @param product  The product name
     * @param quantity The product quantity
     */
    @Override
    public void addProduct(String product, int quantity) {
        if (quantity > 0) {
            if (productMap.containsKey(product)) {
                updateProductQuantity(product, productMap.get(product) + quantity);
            } else {
                productMap.put(product, quantity);
            }
            log.info("{} item(s) of {} was/were added to the basket", quantity, product);
        } else {
            log.error("Quantity cannot be less than 1. The product was not added");
        }
    }

    /**
     * This method allows to remove product from the basket
     *
     * @param product The product name
     */
    @Override
    public void removeProduct(String product) {
        if (productMap.containsKey(product)) {
            productMap.remove(product);
            log.info("The {} was fully removed from the basket", product);
        } else {
            log.error("Deletion of non-existent product. The product was not removed");
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
        for (Map.Entry<String, Integer> pair : productMap.entrySet()) {
            if (product.equals(pair.getKey())) {
                pair.setValue(quantity);
                break;
            }
        }
    }

    /**
     * This method allows to clear the basket
     */
    @Override
    public void clear() {
        productMap.clear();
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
        return new ArrayList<>(productMap.keySet());
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
        if (productMap.containsKey(product)) {
            return productMap.get(product);
        } else {
            log.error("Non-existent product quantity is checked");
            return -1;
        }
    }
}
