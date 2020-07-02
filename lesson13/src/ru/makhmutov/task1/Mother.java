package ru.makhmutov.task1;

import java.util.Random;

public class Mother {

    /**
     * The entry point of ManneredChild program.
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        feed(chooseDish());
    }

    /**
     * This method allows mother to choose the dish for the child
     *
     * @return Chosen food for the child
     */
    private static Food chooseDish() {
        Random rand = new Random();
        int foodNumber = rand.nextInt(Food.values().length);
        Food[] foods = Food.values();
        Food chosenFood = null;
        for (Food food : foods) {
            if (foodNumber == food.ordinal()) {
                chosenFood = food;
                System.out.print("Мама:\n\tСегодня на обед " + chosenFood.getName().toLowerCase());
                System.out.println();
            }
        }
        return chosenFood;
    }

    /**
     * This method allows mother to feed the child by chosen food
     *
     * @param food Chosen food for the child
     */
    private static void feed(Food food) {
        Child child = new Child();
        try {
            child.eat(food);
        } catch (UneatenFoodException e) {
            e.printStackTrace();
        }
    }
}
