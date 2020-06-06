package ru.makhmutov.task4;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HotOrCold {

    /**
     * The entry point of the Petrol program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        HotOrCold h = new HotOrCold();
        Random rand = new Random();
        final int lowerBoundary = 1;
        final int upperBoundary = 100;
        int numberOfTrials = 10;
        int randomNumber = lowerBoundary + rand.nextInt(upperBoundary + 1 - lowerBoundary);
        // initially previous choice is a equal to 0, which indicates that there were not previous trials
        int prevChoice = 0;
        System.out.println("You have to guess the generated number for no more than " + numberOfTrials + " trials");
        System.out.println("To stop the program type -1");
        for (int i = 0; i < numberOfTrials; i++) {
            System.out.print((i + 1) + ". ");
            int choice = h.scanNumber(lowerBoundary, upperBoundary);
            if (choice == randomNumber) {
                System.out.println("Congratulations! The value is guessed after " + (i + 1) + " trials ");
                break;
            } else if (Math.abs(choice - randomNumber) < Math.abs(prevChoice - randomNumber))
                System.out.println("Hotter");
            else if (Math.abs(choice - randomNumber) > Math.abs(prevChoice - randomNumber))
                System.out.println("Colder");
            else if (choice == prevChoice)
                System.out.println("Strange trial, please choose another number");
            prevChoice = choice;
            if (i == numberOfTrials - 1) System.out.println("Game Over. " + "Generated number is " + randomNumber);
        }
    }

    /**
     * This method allows to read valid input values
     *
     * @param lowerBoundary the lower boundary of integer value to be typed
     * @param upperBoundary the upper boundary of integer value to be typed
     * @return The obtained value received via scanning
     */
    private int scanNumber(int lowerBoundary, int upperBoundary) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.print("Choose the number from " + lowerBoundary + " to " + upperBoundary + ": ");
        int value;
        do {
            value = scanner.nextInt();
            if (value == -1) System.exit(0);
            else if (value < lowerBoundary || value > upperBoundary)
                System.out.print("\nPlease enter the number from " + lowerBoundary + " to " + upperBoundary + ": ");
        } while (value < lowerBoundary || value > upperBoundary);
        return value;
    }
}
