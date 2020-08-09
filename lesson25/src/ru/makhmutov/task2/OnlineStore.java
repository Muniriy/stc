package ru.makhmutov.task2;

import java.util.List;

public class OnlineStore {

    /**
     * The entry point of OnlineStore program.
     * This program allows to add products to online basket
     * and remove them, update the amount of products and
     * clear the basket
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        BasketImpl basket = new BasketImpl();
        basket.addProduct("Milk", 5);
        basket.addProduct("Butter", 10);
        displayBasketContent(basket);
        basket.addProduct("Milk", 2);
        displayBasketContent(basket);
        basket.addProduct("Bread", 1);
        basket.addProduct("Bread", 4);
        displayBasketContent(basket);
        basket.removeProduct("Milk");
        displayBasketContent(basket);
        basket.clear();
        displayBasketContent(basket);
    }

    /**
     * This method allows to display all products and their quantities
     * in the basket
     *
     * @param basket The customer's basket
     */
    private static void displayBasketContent(BasketImpl basket) {
        List<String> list = basket.getProducts();
        if (!list.isEmpty()) {
            System.out.println("The basket contains:");
            for (int i = 0; i < list.size(); i++) {
                System.out.format("\t%d. Product %s: %d items%n", i + 1, list.get(i), basket.getProductQuantity(list.get(i)));
            }
            System.out.println();
        }
    }
}
