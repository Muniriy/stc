package ru.makhmutov.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Censor {

    private static final int MINIMAL_STRING_LENGTH = 2;
    private static final String FORBIDDEN = "бяка";
    private static final String REPLACEMENT = "вырезано цензурой";

    /**
     * The entry point of Censor program.
     * THe user types the phrase and then the
     * content replaces each found sequence "бяка" by
     * "вырезано цензурой"
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Censor censor = new Censor();
        try (Scanner scanner = new Scanner(System.in)) {
            censor.scan(scanner);
        }
    }

    /**
     * This method allows to read valid input String values.
     *
     * @param scanner The object of Scanner class needed for scanning the phrase
     */
    private void scan(Scanner scanner) {
        String value;
        boolean validityFlag = false;
        System.out.print("Type the phrase: ");
        do {
            value = scanner.nextLine();
            if (value.length() >= MINIMAL_STRING_LENGTH) {
                String lowerCaseValue = value.toLowerCase();
                if (!isCensoredPhrase(lowerCaseValue)) {
                    validityFlag = true;
                    System.out.println("No censoring required");
                } else {
                    System.out.print("Updated phrase is: ");
                    System.out.println(replaceWithRegExp(value, lowerCaseValue));
                    break;
                }
            } else {
                System.out.format("\nUse strings containing not less than %d Russian alphabet symbols, " +
                        "\ntry one more time: ", MINIMAL_STRING_LENGTH);
            }
        } while (!validityFlag);
    }

    /**
     * This methods returns true if the string contains
     * forbidden word in the phrase. However, it can be
     * part of another word
     *
     * @param phrase the input String
     * @return true - forbidden word is contained in phrase,
     * false - otherwise
     */
    public boolean isCensoredPhrase(String phrase) {
        return phrase.matches("(((.*( |\")+)*)" + FORBIDDEN + "((( |,|!|\\?|\\.|:|;|\")+.*)*)*)");
    }

    /**
     * This method replaces forbidden text with censored text
     *
     * @param phrase          The input phrase
     * @param lowerCasePhrase The input phrase in lower case
     * @return The censored phrase
     */
    private String replaceWithRegExp(String phrase, String lowerCasePhrase) {
        Pattern p = Pattern.compile("\\b" + FORBIDDEN + "\\b");
        Matcher m = p.matcher(lowerCasePhrase);
        StringBuilder sb = new StringBuilder();
        int previousEndingElement = 0;
        while (m.find()) {
            int start = m.start();
            sb.append(phrase, previousEndingElement, start);
            sb.append(REPLACEMENT);
            previousEndingElement = m.end();
        }
        sb.append(phrase.substring(previousEndingElement));
        return sb.toString();
    }
}
