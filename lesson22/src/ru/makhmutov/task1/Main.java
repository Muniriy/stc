package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    /**
     * The entry point of PersonComparator program.
     * This program takes people and sequentially
     * compares them by age and name and then sorts
     * the list of people
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.comparePeople(main.getPeople());
    }

    /**
     * This method allows to create list of people
     * with names and ages
     *
     * @return The array Person[] with inserted people
     */
    private Person[] getPeople() {
        Person[] people = new Person[5];
        people[0] = new Person("Victor", 35);
        people[1] = new Person("Vadim", 51);
        people[2] = new Person("Victor", 24);
        people[3] = new Person("Alex", 51);
        people[4] = new Person("Andrew", 24);
        return people;
    }

    /**
     * This method allows to compare and sort persons by age
     * and then by name
     */
    private void comparePeople(Person[] people) {
        log.info("The list of people before sorting:");
        for (Person p : people) {
            log.info("\t{}", p);
        }

        Arrays.sort(people, new PersonSuperComparator());

        log.info("The list of people after sorting:");
        for (Person p : people) {
            log.info("\t{}", p);
        }
    }
}
