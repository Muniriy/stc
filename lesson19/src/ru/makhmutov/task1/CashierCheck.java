package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CashierCheck {
    private static final Logger log = LogManager.getLogger(CashierCheck.class);
    private static final String PRODUCTS_FILE_PATH = "lesson19/src/files/products.txt";
    private static final String CHECK_FILE_PATH = "lesson19/src/files/check.txt";

    /**
     * The entry point of CashierСheck program.
     * This program reads input data about names, prices, and amounts
     * of bought products and converts it to check, calculating costs
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        CashierCheck cc = new CashierCheck();
        cc.generateCheck(PRODUCTS_FILE_PATH, CHECK_FILE_PATH);
    }

    /**
     * This method allows to read the input file content
     * and convert it to cashier's check
     *
     * @param inputFilePath  The path to the input file
     * @param outputFilePath The path to the output file
     */
    private void generateCheck(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        if (inputFile.exists()) {
            if (inputFile.canRead()) {
                if (outputFile.exists() && outputFile.canWrite() || !outputFile.exists()) {
                    try (Scanner scanner = new Scanner(inputFile).useLocale(Locale.ENGLISH);
                         Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)))) {
                        out.write("Наименование\t\tЦена\t  Кол-во\tСтоимость\n");
                        out.write("=================================================\n");
                        BigDecimal totalCost = new BigDecimal(0);
                        while (scanner.hasNext()) {
                            String product = scan(scanner);
                            if (product != null) {
                                BigDecimal amount = new BigDecimal(Float.toString(scan(scanner, 0)));
                                BigDecimal price = new BigDecimal(Float.toString(scan(scanner, 0)));
                                BigDecimal cost = price.multiply(amount);
                                String line = String.format("%-18s %7.2f x %7.3f = %10.2f %n", product, price, amount, cost);
                                totalCost = totalCost.add(cost).setScale(2, RoundingMode.HALF_UP);
                                out.write(line);
                            } else {
                                System.exit(2);
                            }
                        }
                        out.write("=================================================\n");
                        out.write(String.format("Итого: %42.2f", totalCost));
                    } catch (FileNotFoundException e) {
                        log.error("File \"{}\" cannot be found", outputFile, new FileNotFoundException());
                    } catch (IOException e) {
                        log.error(e);
                    }
                } else {
                    log.error("File \"{}\" cannot be overwritten", outputFile, new SecurityException());
                }
            } else {
                log.error("File \"{}\" cannot be read", inputFile, new SecurityException());
            }
        } else {
            log.error("File \"{}\" cannot be found", inputFile, new FileNotFoundException());
        }
    }

    /**
     * This method allows to scan the String
     *
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private String scan(Scanner scanner) {
        String s = null;
        try {
            s = scanner.nextLine();
        } catch (Exception e) {
            log.error(e);
        }
        return s;
    }

    /**
     * This method allows to read valid float values.
     * The number has to be integer
     *
     * @param scanner       The object of Scanner class needed for scanning the number
     * @param lowerBoundary The lower boundary of the value
     * @return The obtained value received via scanning
     */
    private float scan(Scanner scanner, int lowerBoundary) {
        float value = 0; // the initial value should not be positive to be a barrier for the program
        try {
            value = scanner.nextFloat();
            scanner.nextLine();
            if (value <= lowerBoundary) {
                log.error("The value cannot be negative");
                System.exit(1);
            }
        } catch (InputMismatchException e) {
            log.error("Wrong input", new InputMismatchException());
            System.exit(1);
        } catch (Exception e) {
            log.error(e);
            System.exit(1);
        }
        return value;
    }
}
