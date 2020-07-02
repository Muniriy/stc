package ru.makhmutov.task1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {

    /**
     * This method converts double value into integer if needed
     * and prints it
     *
     * @param value input double value
     */
    private static void converter(double value) {
        if (value == (int) value) {
            System.out.println((int) value);
        } else {
            System.out.println(value);
        }
    }

    /**
     * This method summarizes 2 values
     * and prints the resulting value through the converter() method
     *
     * @param x first value
     * @param y second value
     */
    private static void add(double x, double y) {
        converter(x + y);
    }

    /**
     * This method makes a subtraction
     * and prints the resulting value through the converter() method
     *
     * @param x first value
     * @param y second value
     */
    private static void subtract(double x, double y) {
        converter(x - y);
    }

    /**
     * This method multiplies 2 values
     * and prints the resulting value through the converter() method
     *
     * @param x first value
     * @param y second value
     */
    private static void multiply(double x, double y) {
        converter(x * y);
    }

    /**
     * This method makes a division
     * and prints the resulting value through the converter() method
     *
     * @param x first value
     * @param y second value
     */
    private static void divide(double x, double y) {
        converter(x / y);
    }

    /**
     * This method takes a percentage 'y' from the value 'x'
     * and prints the resulting value through the converter() method
     *
     * @param x the value
     * @param y the percentage
     */
    private static void takePercentage(double x, double y) {
        if (y < 0 || y > 100) {
            System.out.println("Choose applicable percentage");
        }
        converter(x * y / 100);
    }

    /**
     * This method allows to scan the operation number
     *
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private static Operation scanOperation(Scanner scanner) {
        double value = 0.5; // the initial value should not be integer to be a barrier for the program
        boolean inserted = false;
        System.out.print("Type the operation number: ");
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                scanner.next();
                continue;
            }
            for (Operation operation : Operation.values()) {
                if (value == (operation.ordinal() + 1)) {
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                System.out.print("\nPlease insert applicable values: ");
            }

        } while (!inserted);
        return Operation.values()[(int) (value - 1)];
    }

    /**
     * This method allows to read valid input double values.
     *
     * @param scanner         The object of Scanner class needed for scanning the number
     * @param checkBoundaries true - if boundaries have to be checked,
     *                        false - if boundaries do NOT have to be checked
     * @param lowerBoundary   The lower boundary for input value
     * @param upperBoundary   The upper boundary for input value
     * @return The obtained value received via scanning
     */
    private static double scanNumber(Scanner scanner, boolean checkBoundaries, double lowerBoundary, double upperBoundary, String type) {
        double value = -1;
        boolean validityFlag;
        System.out.print("\nType the " + type + ": ");
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                validityFlag = false;
                scanner.next();
                continue;
            }
            if (checkBoundaries) {
                if (lowerBoundary == upperBoundary && value < lowerBoundary) {
                    System.out.format("%nPlease enter the number not lower than %f: ", lowerBoundary);
                    validityFlag = false;
                } else if (lowerBoundary != upperBoundary && (value < lowerBoundary || value > upperBoundary)) {
                    System.out.format("%nPlease enter the number in range [%f; %f]: ", lowerBoundary, upperBoundary);
                    validityFlag = false;
                } else {
                    validityFlag = true;
                }
            } else {
                validityFlag = true;
            }
        } while (!validityFlag);
        return value;
    }

    /**
     * This method displays all operations
     * and their numbers
     */
    private static void seeOperations() {
        System.out.println("Possible operations: ");
        for (Operation operation : Operation.values()) {
            System.out.format("%d. %s%n", (operation.ordinal() + 1), operation.getOp());
        }
    }

    /**
     * The entry point of the Calculator program.
     * The program scans 2 values and performs one of chosen operations
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        seeOperations();
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            Operation operation = scanOperation(scanner);
            double value1;
            double value2;
            if (operation != Operation.TAKE_PERCENTAGE) {
                value1 = scanNumber(scanner, false, 0, 0, "first value");
                value2 = scanNumber(scanner, false, 0, 0, "second value");
            } else {
                value1 = scanNumber(scanner, true, 0, 0, "value");
                value2 = scanNumber(scanner, true, 0, 100, "percentage");
            }
            switch (operation) {
                case ADD:
                    add(value1, value2);
                    break;
                case SUBTRACT:
                    subtract(value1, value2);
                    break;
                case MULTIPLY:
                    multiply(value1, value2);
                    break;
                case DIVIDE:
                    divide(value1, value2);
                    break;
                case TAKE_PERCENTAGE:
                    takePercentage(value1, value2);
                    break;
                default:
                    System.out.println("Wrong operation chosen!");
            }
        }
    }
}
