package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UnrepeatedSymbol {
    private static final Logger log = LogManager.getLogger(UnrepeatedSymbol.class);
    private static final int MIN_STRING_LENGTH = 2;

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
            firstUnrepeatedSymbol(inputString);
        }
    }

    /**
     * This method allows to find the first unrepeated symbol
     * in the string assuming that letter case matters
     *
     * @param inputString The input string for inspection
     */
    private static void firstUnrepeatedSymbol(String inputString) {
        List<Character> symbols = new ArrayList<>();
        for (int i = 0; i < inputString.toCharArray().length; i++) {
            symbols.add(inputString.charAt(i));
        }
        for (char s : symbols) {
            if (Collections.frequency(symbols, s) == 1) {
                log.info("The first unrepeated symbol is \"{}\"", s);
                break;
            }
        }
    }

    /**
     * This method allows to read valid input String values.
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
        return value.trim();
    }
}
