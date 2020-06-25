package ru.makhmutov.task3;

import ru.makhmutov.task3.documents.Act;
import ru.makhmutov.task3.documents.Contract;
import ru.makhmutov.task3.documents.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    private static final int MINIMAL_STRING_LENGTH = 2;
    private static int docID = 0;
    private static int actID = 0;

    /**
     * The entry point of the Documents program.
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
        Calendar date = new GregorianCalendar();
        date.set(Calendar.YEAR, main.scan(scanner, "contract year", 2010, 2020));
        date.set(Calendar.MONTH, main.scan(scanner, "contract month number", 1, 12) - 1);
        date.set(Calendar.DAY_OF_MONTH, main.scan(scanner, "contract day of month", 1, date.getActualMaximum(Calendar.DAY_OF_MONTH)));
        doc = new Contract(++docID, date, goods);
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
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        for (Document d : documents) {
            System.out.println("Document: " + d.getClass().getSimpleName());
            if (d instanceof Act) {
                System.out.println("\tAct ID is " + ((Act) d).getActID());
            }
            System.out.println("\tContract ID is " + d.getId());
            System.out.println("\tDate is " + df.format(d.getDate().getTime()));
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
        Calendar date = new GregorianCalendar();
        Act act;
        System.out.format("Creation of the act %d: %n", (actID + 1));
        date.set(Calendar.YEAR, main.scan(scanner, "act year",
                document.getDate().get(Calendar.YEAR), 2020));
        if (document.getDate().get(Calendar.YEAR) == date.get(Calendar.YEAR)) {
            date.set(Calendar.MONTH, main.scan(scanner,
                    "act month number", document.getDate().get(Calendar.MONTH) + 1, 12) - 1);
            if (document.getDate().get(Calendar.MONTH) == date.get(Calendar.MONTH)) {
                date.set(Calendar.DAY_OF_MONTH, main.scan(scanner, "act day of month",
                        document.getDate().get(Calendar.DAY_OF_MONTH), date.getActualMaximum(Calendar.DAY_OF_MONTH)));
            } else if (document.getDate().get(Calendar.MONTH) < date.get(Calendar.MONTH)) {
                date.set(Calendar.DAY_OF_MONTH, main.scan(scanner, "act day of month",
                        1, date.getActualMaximum(Calendar.DAY_OF_MONTH)));
            }

        } else if (document.getDate().get(Calendar.YEAR) < date.get(Calendar.YEAR)) {
            date.set(Calendar.MONTH, main.scan(scanner,
                    "act month number", 1, 12) - 1);
            date.set(Calendar.DAY_OF_MONTH, main.scan(scanner, "act day of month",
                    1, date.getActualMaximum(Calendar.DAY_OF_MONTH)));
        }
        act = new Act(document.getId(), date, document.getGoods(), ++actID);
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
