package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CharsetChanger {
    private static final Logger log = LogManager.getLogger(CharsetChanger.class);
    private static final String ORIGINAL_FILE_PATH = "lesson18/files/file1.txt";
    private static final String COPIED_FILE_PATH = "lesson18/files/file2.txt";

    /**
     * The entry point of CharsetChanger program.
     * The program copies file content with one charset
     * to another file with another charset
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        readAndWrite(ORIGINAL_FILE_PATH, COPIED_FILE_PATH, StandardCharsets.UTF_8, Charset.forName("Windows-1251"));
    }

    /**
     * This method allows to read valid input values
     *
     * @param valueNo The number of current value: 1 or 2
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private static double scanNumber(int valueNo, Scanner scanner) {
        System.out.print("\nType the value " + valueNo + ": ");
        double value = 0;
        boolean isValueChanged;
        do {
            try {
                value = scanner.nextDouble();
                isValueChanged = true;
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                isValueChanged = false;
                scanner.next();
            }
        } while (!isValueChanged);
        return value;
    }


    /**
     * This method allows to read the input file content in given charset,
     * convert it to the output file charset and write it there
     *
     * @param inputFilePath     The path to the input file
     * @param outputFilePath    The path to the output file
     * @param inputFileCharset  The charset of the input file
     * @param outputFileCharset The charset of the output file
     */
    private static void readAndWrite(String inputFilePath, String outputFilePath, Charset inputFileCharset, Charset outputFileCharset) {
        try (Reader in = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), inputFileCharset));
             Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), outputFileCharset))) {
            char[] cbuf = new char[2048];
            int len;
            while ((len = in.read(cbuf, 0, cbuf.length)) != -1) {
                out.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e);
        }
    }
}
