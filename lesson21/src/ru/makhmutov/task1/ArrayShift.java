package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ArrayShift {
    private static final Logger log = LogManager.getLogger(ArrayShift.class);
    private static final int ARRAY_ROWS = 5;
    private static final int ARRAY_COLS = 4;

    /**
     * The entry point of ArrayShift program.
     * This program shifts left each row's elements of input 2D array
     * by 1 element and prints the resulting array
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        int[][] array = new int[ARRAY_ROWS][ARRAY_COLS];
        fillArray(array);
        displayArray(array);
        toLeft(array);
        displayArray(array);
    }

    /**
     * This method allows to shift left each row's element
     * of the 2D array by 1 element
     *
     * @param array The 2D array
     */
    private static void toLeft(int[][] array) {
        for (int i = 0; i < ARRAY_ROWS; i++) {
            for (int j = 0; j < ARRAY_COLS - 1; j++) {
                array[i][j] = array[i][j + 1];
            }
            array[i][ARRAY_COLS - 1] = 0;
        }
        log.info("Each row's element of the 2D array is shifted left by 1 element");
    }

    /**
     * This method allows to display the 2D array elements
     *
     * @param array The empty 2D array
     */
    private static void displayArray(int[][] array) {
        for (int i = 0; i < ARRAY_ROWS; i++) {
            for (int j = 0; j < ARRAY_COLS; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        log.info("The 2D array is displayed");
    }

    /**
     * This method allows to fill the 2D array by random values
     *
     * @param array The empty 2D array
     */
    private static void fillArray(int[][] array) {
        Random random = new Random(7);
        for (int i = 0; i < ARRAY_ROWS; i++) {
            for (int j = 0; j < ARRAY_COLS; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        log.info("The 2D array is filled");
    }
}
