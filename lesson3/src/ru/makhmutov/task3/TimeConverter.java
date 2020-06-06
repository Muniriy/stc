package ru.makhmutov.task3;

import java.util.Scanner;

public class TimeConverter {

    /**
     * The entry point of the TimeConverter program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        TimeConverter t = new TimeConverter();
        int seconds = t.scanNumber();
        int minInHour = 60;
        int secInMin = 60;
        float hours = (float) seconds / secInMin / minInHour;
        System.out.println("\n" + seconds + " second(s) is equal to " + hours + " hour(s)");
    }

    /**
     * This method allows to read valid input values
     *
     * @return The obtained value received via scanning
     */
    private int scanNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nType the number of seconds: ");
        int value;
        do {
            value = scanner.nextInt();
            if (value < 0)
                System.out.print("\nPlease enter the positive number for the time: ");
        } while (value <= 0);
        return value;
    }
}
