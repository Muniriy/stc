package ru.makhmutov.task1;

public class NullPointer {

    private static final String MESSAGE = "Hello, World!";

    /**
     * The entry point of NullPointer program.
     * It fills the 1st element of String array by message
     * and prints all elements of the array in original and lower case,
     * because of which NullPointerException is achieved for 0th null element
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        String[] array = new String[2];
        array[1] = MESSAGE;
        for (String msg : array) {
            System.out.println(msg);
            String lowerCaseMsg = msg.toLowerCase();
            System.out.println(lowerCaseMsg);
        }
    }
}
