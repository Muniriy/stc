package ru.makhmutov.task2;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class NumberDescriber {

    /**
     * This method allows to read valid input values.
     * The number has to be integer
     *
     * @return The obtained value received via scanning
     */
    private static int scanNumber() {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.print("\nType the integer value: ");
            double value = 0.5; // the initial value should not be integer to be a barrier for the program
            do {
                try {
                    value = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("\nDo not enter characters, try one more time: ");
                    scanner.next();
                    continue;
                }
                if (value != (int) value) {
                    System.out.print("\nPlease enter the integer number: ");
                }
            } while (value != (int) value);
            return (int) value;
        }
    }

    /**
     * This method describes the number by saying
     * if it is positive, negative or equal to zero.
     * Also, this method checks if the number is even or odd
     *
     * @param value the input integer value
     */
    private static void describeNumber(int value) {
        if (value > 0) {
            System.out.print("The number is positive and ");
        } else if (value < 0) {
            System.out.print("The number is negative and ");
        } else {
            System.out.print("The number is equal to 0 and it is ");
        }

        if (value % 2 == 0) {
            System.out.print("even");
        } else {
            System.out.print("odd");
        }
    }

    /**
     * The entry point of the NumberDescriber program.
     * This method scans the integer number by scanNumber()
     * and provides its description by describeNumber()
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        describeNumber(scanNumber());
    }
}
