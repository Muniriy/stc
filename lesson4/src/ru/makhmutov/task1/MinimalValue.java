package ru.makhmutov.task1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MinimalValue {

    /**
     * This method allows to read valid input values
     *
     * @param valueNo The number of current value: 1 or 2
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private static double scanNumber(int valueNo, Scanner scanner) {
        System.out.print("\nType the value " + valueNo + ": ");
        double value = 0;
        boolean isValueChanged;
        do {
            try {
                value = scanner.nextDouble();
                isValueChanged = true;
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                isValueChanged = false;
                scanner.next();
            }
        } while (!isValueChanged);
        return value;
    }

    /**
     * This method gets the minimal value our of 2 given
     *
     * @param value1 the first double value
     * @param value2 the second double value
     */
    private static void getMinimalValue(double value1, double value2) {
        if (value1 != value2) {
            double result = Math.min(value1, value2);
            if (result == (int) result) {
                System.out.println("The minimal number is " + (int) result);
            } else {
                System.out.println("The minimal number is " + result);
            }
        } else System.out.println("The numbers are equal");
    }

    /**
     * The entry point of the MinimalValue program.
     * Initially program scans 2 double values, by calling scanNumber()
     * then getMinimalNumber() calculates the minimal value
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            double value1 = scanNumber(1, scanner);
            double value2 = scanNumber(2, scanner);
            getMinimalValue(value1, value2);
        }
    }
}
