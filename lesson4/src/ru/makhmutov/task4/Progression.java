package ru.makhmutov.task4;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Progression {

    /**
     * This method trims mantissa of number with double
     * precision if it is equal to 0 and then prints it
     *
     * @param value The input value with double precision
     */
    private static void printIntOrDouble(double value) {
        if (value == (int) value) {
            System.out.print(" " + (int) value);
        } else {
            System.out.print(" " + value);
        }
    }

    /**
     * This method displays the arithmetic or geometric progression
     * based on given input arguments
     *
     * @param progressionType  It is an integer value, which defines
     *                         the type of progression that can be:
     *                         0 - arithmetic;
     *                         1 - geometric
     * @param firstElement     The first double value of a progression
     * @param commonDifOrRatio The common difference in case of
     *                         arithmetic progression and
     *                         the common ratio in case of
     *                         geometric progression
     * @param memberCount      The count of members to be displayed
     */
    private static void displayProgression(int progressionType, double firstElement,
                                           double commonDifOrRatio, int memberCount) {
        if (progressionType == 0) {
            System.out.print("\nArithmetic progression:");
            printIntOrDouble(firstElement);
            for (int i = 2; i <= memberCount; i++) {
                double curElement = firstElement + commonDifOrRatio * (i - 1);
                printIntOrDouble(curElement);
            }
        } else if (progressionType == 1) {
            System.out.print("\nGeometric progression:");
            printIntOrDouble(firstElement);
            double curElement = firstElement;
            for (int i = 2; i <= memberCount; i++) {
                curElement *= commonDifOrRatio;
                printIntOrDouble(curElement);
            }
        }
    }

    /**
     * /**
     * This method allows to read valid input values.
     *
     * @param scanner       The object of Scanner class needed for scanning the number
     * @param name          The string which defines the name of the value
     * @param valueType     The type of the value:
     *                      0 - int
     *                      1 - double
     * @param lowerBoundary The lower boundary for number
     * @param upperBoundary The upper boundary for number
     * @return The obtained value received via scanning
     */
    private static double scanNumber(Scanner scanner, String name, double valueType, double lowerBoundary, double upperBoundary) {

        if (valueType == 0) {
            System.out.format("\nType the integer number in range [%d; %d] to define the %s: ", (int) lowerBoundary, (int) upperBoundary, name);
        } else if (valueType == 1) {
            System.out.format("\nType the double number in range [%6.3e; %6.3e] to define the %s: ", lowerBoundary, upperBoundary, name);
        }
        double value = 0;
        boolean validityFlag;
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                validityFlag = false;
                scanner.next();
                continue;
            }
            if (value < lowerBoundary || value > upperBoundary) {
                System.out.format("\nPlease enter the number in given range: ");
                validityFlag = false;
                continue;
            }
            if (valueType == 0 && value != (int) value) {
                System.out.print("\nPlease enter the integer number: ");
                validityFlag = false;
            } else {
                validityFlag = true;
            }
        } while (!validityFlag);
        return value;
    }

    /**
     * The entry point of the Progression program.
     * firstly program scans all inout values and
     * then displays the progression in console
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            int progressionType = (int) scanNumber(scanner, "type of progression", 0, 0, 1);
            double firstElement = scanNumber(scanner, "first element", 1, -Double.MAX_VALUE, Double.MAX_VALUE);
            double commonDifOrRatio = scanNumber(scanner, "common difference or ratio", 1, -Double.MAX_VALUE, Double.MAX_VALUE);
            int memberCount = (int) scanNumber(scanner, "member count", 0, 1, Integer.MAX_VALUE);
            displayProgression(progressionType, firstElement, commonDifOrRatio, memberCount);
        }
    }
}
