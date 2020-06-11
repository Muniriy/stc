package ru.makhmutov.task4;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HotOrCold {

    private final static int lowerBoundary = 1;
    private final static int upperBoundary = 100;
    private final static int numberOfTrials = 10;

    /**
     * The entry point of the HotOrCold program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = lowerBoundary + rand.nextInt(upperBoundary + 1 - lowerBoundary);
        // initially previous choice is a equal to 0, which indicates that there were not previous trials
        int prevChoice = 0;
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.println("You have to guess the generated number for no more than " + numberOfTrials + " trials");
            System.out.println("To stop the program type -1");
            for (int i = 0; i < numberOfTrials; i++) {
                System.out.print((i + 1) + ". ");
                int choice = scanNumber(lowerBoundary, upperBoundary, scanner);
                if (choice == randomNumber) {
                    System.out.println("Congratulations! The value is guessed after " + (i + 1) + " trials ");
                    break;
                } else if (Math.abs(choice - randomNumber) < Math.abs(prevChoice - randomNumber)) {
                    System.out.println("Hotter");
                } else if (Math.abs(choice - randomNumber) > Math.abs(prevChoice - randomNumber)) {
                    System.out.println("Colder");
                } else if (choice == prevChoice) {
                    System.out.println("Strange trial, please choose another number");
                }
                prevChoice = choice;
                if (i == numberOfTrials - 1) {
                    System.out.println("Game Over. " + "Generated number is " + randomNumber);
                }
            }
        }
    }

    /**
     * This method allows to read valid input values
     *
     * @param lowerBoundary the lower boundary of integer value to be typed
     * @param upperBoundary the upper boundary of integer value to be typed
     * @return The obtained value received via scanning
     */
    private static int scanNumber(int lowerBoundary, int upperBoundary, Scanner scanner) {
        System.out.print("Choose the number from " + lowerBoundary + " to " + upperBoundary + ": ");
        int value = lowerBoundary - 100; // the initial value should be out of boundaries to be a barrier for the program
        do {
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                scanner.next();
                continue;
            }
            if (value == -1) {
                System.exit(0);
            } else if (value < lowerBoundary || value > upperBoundary) {
                System.out.print("\nPlease enter the number from " + lowerBoundary + " to " + upperBoundary + ": ");
            }
        } while (value < lowerBoundary || value > upperBoundary);
        return value;
    }
}
