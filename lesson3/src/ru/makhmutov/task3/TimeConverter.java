package ru.makhmutov.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TimeConverter {

    private final static int minInHour = 60;
    private final static int secInMin = 60;

    /**
     * The entry point of the TimeConverter program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        float seconds = scanNumber();
        float hours = seconds / secInMin / minInHour;
        System.out.println("\n" + seconds + " second(s) is equal to " + hours + " hour(s)");
    }

    /**
     * This method allows to read valid input values
     *
     * @return The obtained value received via scanning
     */
    private static float scanNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nType the number of seconds: ");
            float value = -1;
            do {
                try {
                    value = scanner.nextFloat();
                } catch (InputMismatchException e) {
                    System.out.print("\nDo not enter characters, try one more time: ");
                    scanner.next();
                    continue;
                }
                if (value < 0) {
                    System.out.print("\nPlease enter the positive number for the time: ");
                }
            } while (value <= 0);
            return value;
        }
    }
}
