package ru.makhmutov.task1;

public class Petrol {

    private static final float PRICE = 43.5F;

    /**
     * The entry point of the Petrol program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            float amount = Float.parseFloat(args[0]);
            if (amount > 0) {
                float cost = PRICE * amount;
                System.out.println("\nThe cost of petrol is " + cost + " Roubles");
            } else System.out.println("The value has to be greater than 0");
        } else System.out.println("The amount of petrol has to be defined by the argument");
    }
}
