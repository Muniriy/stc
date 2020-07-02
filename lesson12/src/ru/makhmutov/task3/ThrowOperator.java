package ru.makhmutov.task3;

import java.util.Scanner;

public class ThrowOperator {

    private static final int MINIMAL_STRING_LENGTH = 2;
    private static final String FORBIDDEN_MESSAGE = "Hello, World!";

    /**
     * The entry point of ThrowOperator program.
     * It reads the input message and prints it if it is not forbidden
     * or throws exception otherwise
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        String inputMessage = scan();
        try {
            printMessage(inputMessage);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods prints the input message if it is not forbidden
     * or throws the exception otherwise
     *
     * @throws MyException in case of forbidden message
     */
    public static void printMessage(String inputMessage) throws MyException {
        if (inputMessage.equals(FORBIDDEN_MESSAGE)) {
            throw new MyException();
        } else {
            System.out.println(inputMessage);
        }
    }

    /**
     * This method allows to read valid input String values.
     *
     * @return The obtained value received via scanning
     */
    private static String scan() {
        Scanner scanner = new Scanner(System.in);
        String value;
        boolean validityFlag = false;
        System.out.print("Type the message: ");
        do {
            value = scanner.nextLine();
            if (value.length() >= MINIMAL_STRING_LENGTH) {
                validityFlag = true;
            } else {
                System.out.format("\nUse strings containing not less than %d symbols," +
                        "\ntry one more time: ", MINIMAL_STRING_LENGTH);
            }
        } while (!validityFlag);
        return value;
    }
}
