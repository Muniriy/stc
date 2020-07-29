package ru.makhmutov.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ReversedArray {
    private static final Logger log = LogManager.getLogger(ReversedArray.class);
    private static final int ARRAY_SIZE1 = 9;
    private static final int ARRAY_SIZE2 = 10;

    /**
     * The entry point of ReversedArray program.
     * This program takes 1D array, inverts its' elements
     * and displays the resulting array
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        int[] array1 = new int[ARRAY_SIZE1];
        fillArray(array1);
        displayArray(array1);
        reverseArray(array1);
        displayArray(array1);

        System.out.println();

        int[] array2 = new int[ARRAY_SIZE2];
        fillArray(array2);
        displayArray(array2);
        reverseArray(array2);
        displayArray(array2);
    }

    /**
     * This method allows to inverse the elements of the array
     *
     * @param array The array
     */
    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        log.info("The array is reversed");
    }

    /**
     * This method allows to display the array elements
     *
     * @param array The array
     */
    private static void displayArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
        log.info("The array is displayed");
    }

    /**
     * This method allows to fill the array by random values
     *
     * @param array The empty array
     */
    private static void fillArray(int[] array) {
        Random random = new Random(7);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        log.info("The array is filled");
    }
}
