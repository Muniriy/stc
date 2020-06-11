package ru.makhmutov.task3;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MultiplicationTable {

    static int initialMultiplier = 2;

    /**
     * This method allows to read valid input values.
     * The number has to be positive integer greater than initialMultiplier
     *
     * @return The obtained value received via scanning
     */
    private static int scanNumber() {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.print("\nType the integer number not less than " + initialMultiplier +
                    ",\nwhich will be multiplier for the last collumn: ");
            double value = 0; // the initial value should be out of boundaries to be a barrier for the program
            do {
                try {
                    value = scanner.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.print("\nDo not enter characters, try one more time: ");
                    scanner.next();
                    continue;
                }
                if (value < initialMultiplier || value != (int) value) {
                    System.out.print("\nPlease enter the integer number not less than " + initialMultiplier + ": ");
                }
            } while (value < initialMultiplier || value != (int) value);
            return (int) value;
        }
    }

    /**
     * The entry point of the MultiplicationTable program.
     * The program prints multiplication table beginning with
     * the first predefined multiplier equal to initialMultiplier
     * and ending with the input value scanned by scanNumber()
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        int tableSize = scanNumber();
        for (int i = initialMultiplier; i <= tableSize; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.format("%2d x %2d = %2d\n", i, j, i * j);
            }
            System.out.println();
        }
    }
}
