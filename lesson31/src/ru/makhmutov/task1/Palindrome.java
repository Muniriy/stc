package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Palindrome {
    private static final Logger log = LogManager.getLogger(Palindrome.class);
    private static final int MIN_STRING_LENGTH = 1;

    /**
     * The entry point of UnrepeatedSymbol program.
     * This program allows to find the first unrepeated symbol
     * in the string
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputString = scan(scanner);
            checkPalindromeFirstMethod(inputString);
            checkPalindromeSecondMethod(inputString);
        }
    }

    /**
     * This method allows to check if the input message is palindrome
     * or not using comparison of boundary elements of the string and
     * moving towards the centre of the string from the both sides
     *
     * @param inputString The input string
     */
    private static void checkPalindromeFirstMethod(String inputString) {
        for (int leftElement = 0, rightElement = inputString.length() - 1; leftElement <= rightElement; leftElement++, rightElement--) {
            if (inputString.toCharArray()[leftElement] != inputString.toCharArray()[rightElement]) {
                log.info("First method: \"{}\" is NOT a palindrome", inputString);
                return;
            }
        }
        log.info("First method: \"{}\" is a palindrome", inputString);
    }

    /**
     * This method allows to check if the input message is palindrome
     * or not using
     *
     * @param inputString The input string
     */
    private static void checkPalindromeSecondMethod(String inputString) {
        StringBuilder reversedString = new StringBuilder();
        for (int stringIndex = inputString.length() - 1; stringIndex >= 0; stringIndex--) {
            reversedString.append(inputString.charAt(stringIndex));
        }
        if (inputString.equals(reversedString.toString())) {
            log.info("Second method: \"{}\" is a palindrome", inputString);
        } else {
            log.info("Second method: \"{}\" is NOT a palindrome", inputString);
        }
    }

    /**
     * This method allows to read valid input String values.
     * It trims the input and converts it to lower case
     *
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private static String scan(Scanner scanner) {
        String value;
        boolean validityFlag = false;
        log.info("Please print the string: ");
        do {
            value = scanner.nextLine();
            value = value.trim();
            if (value.length() >= MIN_STRING_LENGTH) {
                validityFlag = true;
            } else {
                log.warn("Use string not shorter than {}: ", MIN_STRING_LENGTH);
            }
        } while (!validityFlag);
        return value.trim().toLowerCase();
    }
}
