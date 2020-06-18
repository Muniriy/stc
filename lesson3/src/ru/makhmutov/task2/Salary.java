package ru.makhmutov.task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Salary {

    private static final BigDecimal NDFL = new BigDecimal("0.13");

    /**
     * The entry point of the Salary program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        BigDecimal salary = scanNumber();
        MathContext mc = new MathContext(6);
        BigDecimal percentage = BigDecimal.ONE.subtract(NDFL, mc);
        BigDecimal salaryMinusNdfl = salary.multiply(percentage, mc);
        System.out.println("\nThe salary without NDFL is " + salaryMinusNdfl + " Roubles");
    }

    /**
     * This method allows to read valid input values
     *
     * @return The obtained value received via scanning
     */
    private static BigDecimal scanNumber() {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            System.out.print("\nType the salary (apply dot for mantissa if needed): ");
            BigDecimal value = new BigDecimal(-1);
            do {
                try {
                    value = scanner.nextBigDecimal();
                } catch (InputMismatchException e) {
                    System.out.print("\nDo not enter characters, try one more time: ");
                    scanner.next();
                    continue;
                }
                if (value.compareTo(BigDecimal.ZERO) <= 0) {
                    System.out.print("\nPlease enter the positive number for the salary: ");
                }
            } while (value.compareTo(BigDecimal.ZERO) <= 0);
            return value;
        }
    }
}
