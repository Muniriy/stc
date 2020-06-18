package ru.makhmutov.task4;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class HotOrCold {

    private static final int LOWER_BOUNDARY = 1;
    private static final int UPPER_BOUNDARY = 100;
    private static final int NUMBER_OF_TRIALS = 10;

    /**
     * The entry point of the HotOrCold program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = LOWER_BOUNDARY + rand.nextInt(UPPER_BOUNDARY + 1 - LOWER_BOUNDARY);
        // initially previous choice is a equal to 0, which indicates that there were not previous trials
        int prevChoice = 0;
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.println("You have to guess the generated number for no more than " + NUMBER_OF_TRIALS + " trials");
            System.out.println("To stop the program type -1");
            for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
                System.out.print((i + 1) + ". ");
                int choice = scanNumber(LOWER_BOUNDARY, UPPER_BOUNDARY, scanner);
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
                if (i == NUMBER_OF_TRIALS - 1) {
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
