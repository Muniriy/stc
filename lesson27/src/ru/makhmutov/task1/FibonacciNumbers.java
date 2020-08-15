package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

public class FibonacciNumbers {
    private static final Logger log = LogManager.getLogger(FibonacciNumbers.class);
    private static final int ELEMENTS_NUMBER = 100;

    /**
     * The entry point of FibonacciNumbers program.
     * This program allows to get the sequence of
     * Fibonacci numbers using iterative and recursive
     * approaches
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        FibonacciNumbers fn = new FibonacciNumbers();
        if (ELEMENTS_NUMBER > 0) {
            fn.iterativeFibonacci(ELEMENTS_NUMBER);
            fn.recursiveFibonacciSequence();
        } else {
            log.error("Impossible to calculate Fibonacci sequence with length less than 1");
        }
    }

    /**
     * This method allows to calculate and display
     * sequence of Fibonacci numbers using iterative
     * approach
     *
     * @param elementsNumber The number of elements in sequence
     */
    private void iterativeFibonacci(int elementsNumber) {
        BigInteger prevValue = BigInteger.ZERO;
        BigInteger curValue = BigInteger.ONE;
        System.out.print("0 ");
        for (int i = 1; i < elementsNumber; i++) {
            curValue = curValue.add(prevValue);
            prevValue = curValue.subtract(prevValue);
            System.out.printf("%d ", prevValue);
        }
        System.out.println();
        log.info("Iterative Fibonacci method is performed");
        System.out.println();
    }

    /**
     * This method calls recursive Fibonacci method
     * for each sequence element
     */
    private void recursiveFibonacciSequence() {
        for (int i = 1; i <= ELEMENTS_NUMBER; i++) {
            System.out.print(recursiveFibonacci(i)[0] + " ");
        }
        System.out.println();
        log.info("Recursive Fibonacci method is performed");
    }

    /**
     * This method allows to calculate and display
     * number from Fibonacci sequence using recursive
     * approach
     *
     * @param elementsNumber The number of elements in sequence
     * @return The value of Fibonacci sequence element
     */
    private BigInteger[] recursiveFibonacci(int elementsNumber) {
        BigInteger[] arr = new BigInteger[2];
        if (elementsNumber == 1) {
            arr[0] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            return arr;
        } else {
            arr = recursiveFibonacci(elementsNumber - 1);
            BigInteger[] arr2 = new BigInteger[2];
            BigInteger temp = arr[0].add(arr[1]);
            arr2[0] = arr[1];
            arr2[1] = temp;
            return arr2;
        }
    }
}
