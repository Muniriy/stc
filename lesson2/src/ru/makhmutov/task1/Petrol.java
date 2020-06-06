package ru.makhmutov.task1;

public class Petrol {

    /**
     * The entry point of the Petrol program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        float price = 43.5F;
        if (args.length == 1) {
            float amount = Float.parseFloat(args[0]);
            if (amount > 0) {
                float cost = price * amount;
                System.out.println("\nThe cost of petrol is " + cost + " Roubles");
            } else System.out.println("The value has to be greater than 0");
        } else System.out.println("The amount of petrol has to be defined by the argument");
    }
}
