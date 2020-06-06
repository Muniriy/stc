package ru.makhmutov.task2;

import java.util.Locale;
import java.util.Scanner;

public class Salary {

    /**
     * The entry point of the Salary program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Salary s = new Salary();
        float salary = s.scanNumber();
        float ndfl = 0.13F;
        float salaryMinusNdfl = salary * (1 - ndfl);
        System.out.println("\nThe salary without NDFL is " + salaryMinusNdfl + " Roubles");
    }

    /**
     * This method allows to read valid input values
     *
     * @return The obtained value received via scanning
     */
    private float scanNumber() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.print("\nType the salary (apply dot for mantissa if needed): ");
        float value;
        do {
            value = scanner.nextFloat();
            if (value <= 0)
                System.out.print("\nPlease enter the positive number for the salary: ");
        } while (value <= 0);
        return value;
    }
}
