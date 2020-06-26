package ru.makhmutov.task3;

import ru.makhmutov.task3.documents.Act;
import ru.makhmutov.task3.documents.Contract;
import ru.makhmutov.task3.documents.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int MINIMAL_STRING_LENGTH = 2;
    private static int docID = 0;
    private static int actID = 0;

    /**
     * The entry point of the Documents program.
     * The list of contracts created, each contract is filled
     * by input data. After filling information, all documents
     * are displayed. For each document realted act is generated
     * and displayed
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        int docNumber = 2;
        List<Document> contracts = new ArrayList<>(docNumber);
        List<Document> acts = new ArrayList<>(docNumber);
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < docNumber; i++) {
                contracts.add(createContract(scanner));
            }
            displayDocuments(contracts);

            for (Document contract : contracts) {
                acts.add(contractToActConverter(contract, scanner));
            }
            displayDocuments(acts);
        }

    }

    /**
     * This method allows to create contract with input data
     *
     * @return Created contract
     */
    private static Contract createContract(Scanner scanner) {
        Contract doc;
        Main main = new Main();
        System.out.format("Creation of the contract %d: %n", (docID + 1));
        int goodsTypes = main.scan(scanner, "number of goods", 1, 100);
        String[] goods = new String[goodsTypes];
        for (int i = 0; i < goodsTypes; i++) {
            goods[i] = main.scan(scanner, "name of good " + (i + 1));
        }

        int year = main.scan(scanner, "contract year", 2010, 2020);
        int month = main.scan(scanner, "contract month number", 1, 12);
        int dayOfMonth = main.scan(scanner, "contract day of month", 1, LocalDate.of(year, month, 1).lengthOfMonth());
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        doc = new Contract(++docID, localDate, goods);
        System.out.println("Contract " + docID + " is created");
        System.out.println();
        return doc;
    }

    /**
     * This methods displays all fields of all existing documents
     *
     * @param documents List with all documents
     */
    private static void displayDocuments(List<Document> documents) {
        for (Document d : documents) {
            System.out.println("Document: " + d.getClass().getSimpleName());
            if (d instanceof Act) {
                System.out.println("\tAct ID is " + ((Act) d).getActID());
            }
            System.out.println("\tContract ID is " + d.getId());
            System.out.println("\tDate is " + d.getDate());
            System.out.println("\tGoods are:");
            for (int i = 0; i < d.getGoods().length; i++) {
                System.out.format("\t\t%d. %s%n", (i + 1), d.getGoods()[i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * This method converts contracts to act.
     * Additionally each act has a unique Act ID and date not less
     * than the date of contract
     *
     * @param document The contract needed for conversion
     * @return The converted act
     */
    private static Act contractToActConverter(Document document, Scanner scanner) {
        Main main = new Main();
        Act act;
        System.out.format("Creation of the act %d: %n", (actID + 1));
        int year = main.scan(scanner, "act year", document.getDate().getYear(), 2020);
        int month = 0;
        int dayOfMonth = 0;
        if (document.getDate().getYear() == year) {
            month = main.scan(scanner, "act month number",
                    document.getDate().getMonthValue(), 12);
            if (document.getDate().getMonthValue() == month) {
                dayOfMonth = main.scan(scanner, "act day of month",
                        document.getDate().getDayOfMonth(), LocalDate.of(year, month, 1).lengthOfMonth());
            } else if (document.getDate().getMonthValue() < month) {
                dayOfMonth = main.scan(scanner, "act day of month",
                        1, LocalDate.of(year, month, 1).lengthOfMonth());
            }
        } else if (document.getDate().getYear() < year) {
            month = main.scan(scanner, "act month number", 1, 12);
            dayOfMonth = main.scan(scanner, "act day of month", 1,
                    LocalDate.of(year, month, 1).lengthOfMonth());
        }
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        act = new Act(document.getId(), localDate, document.getGoods(), ++actID);
        System.out.println("Act " + actID + " is created");
        System.out.println();
        return act;
    }

    /**
     * This method allows to read valid input values
     *
     * @param lowerBoundary the lower boundary of integer value to be typed
     * @param upperBoundary the upper boundary of integer value to be typed
     * @return The obtained value received via scanning
     */
    private int scan(Scanner scanner, String inputType, int lowerBoundary, int upperBoundary) {
        System.out.format("Choose the %s from %d till %d: ", inputType, lowerBoundary, upperBoundary);
        int value = lowerBoundary - 100; // the initial value should be out of boundaries to be a barrier for the program
        do {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
            } else {
                System.out.print("\nDo not enter characters, try one more time: ");
                scanner.next();
                continue;
            }
            if (value < lowerBoundary || value > upperBoundary) {
                System.out.print("\nPlease enter the number from " + lowerBoundary + " to " + upperBoundary + ": ");
            }
        } while (value < lowerBoundary || value > upperBoundary);
        return value;
    }

    /**
     * This methods returns true if the string consists
     * of only English alphabet letters and begins with
     * the capital letter
     *
     * @param name the input String
     * @return true - only English letters, the first is capital,
     * false - otherwise
     */
    public boolean isAlphabetSymbol(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    /**
     * This method allows to read valid input String values.
     *
     * @param scanner   The object of Scanner class needed for scanning the number
     * @param inputType The string which defines the name of the value
     * @return The obtained value received via scanning
     */
    private String scan(Scanner scanner, String inputType) {
        String value;
        boolean validityFlag = false;
        System.out.print("Type the " + inputType + ": ");
        do {
            value = scanner.next();
            if (isAlphabetSymbol(value) && value.length() >= MINIMAL_STRING_LENGTH) {
                validityFlag = true;
            } else {
                System.out.format("\nUse strings containing not less than %d English alphabet symbols" +
                        "\nand beginning with capital letter, try one more time: ", MINIMAL_STRING_LENGTH);
            }
        } while (!validityFlag);
        return value;
    }
}
