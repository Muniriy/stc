package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class SetFiltering {
    private static final Logger log = LogManager.getLogger(SetFiltering.class);

    /**
     * The entry point of SetFiltering program.
     * This program filter all elements of the Set
     * with the odd length and leave elements with even
     * length
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        SetFiltering sf = new SetFiltering();
        Set<String> set = sf.createSet();
        sf.displaySet(set);
        set = sf.removeEvenLength(set);
        sf.displaySet(set);
    }

    /**
     * This method initializes set with elements
     * of even and odd lengths
     *
     * @return The filled set
     */
    private Set<String> createSet() {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("world");
        set.add("Hi");
        set.add("Bye");
        set.add("goodbye");
        set.add("fine");
        set.add("1234");
        log.info("The set is initialized");
        return set;
    }

    /**
     * This method allows to display the set elements
     *
     * @param set The input set
     */
    private void displaySet(Set<String> set) {
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
        log.info("The set is displayed");
    }

    /**
     * This method checks if the length of the
     * string is even or not
     *
     * @param string The input string
     * @return True if the string length is even,
     * otherwise - false
     */
    private boolean isEvenLength(String string) {
        return string.length() % 2 == 0;
    }

    /**
     * This method allows to remove all elements of the
     * set with even length
     *
     * @param set The input set
     * @return The set with removed even-length elements
     */
    public Set<String> removeEvenLength(Set<String> set) {
        set.removeIf(this::isEvenLength);
        log.info("Elements with even length are removed from set");
        return set;
    }
}
