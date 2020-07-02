package ru.makhmutov.task2;

public class ArrayOutOfBounds {

    private static final String MESSAGE = "Hello, World!";

    /**
     * The entry point of ArrayOutOfBounds program.
     * It repeatedly prints the message and tries to
     * achieve ArrayIndexOutOfBoundsException
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        printMessage(5);
    }

    /**
     * This method fills each element of String array with the same message
     * and prints the content. Intentionally the method tries to fill the
     * element of the array out of bounds to get ArrayIndexOutOfBoundsException
     */
    private static void printMessage(int repetitions) {
        String[] array = new String[repetitions];
        for (int i = 0; i <= array.length; i++) {
            array[i] = MESSAGE;
            System.out.println(array[i]);
        }
    }
}
