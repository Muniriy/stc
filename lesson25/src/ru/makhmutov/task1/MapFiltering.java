package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class MapFiltering {
    private static final Logger log = LogManager.getLogger(MapFiltering.class);

    /**
     * The entry point of MapFiltering program.
     * This program filter all elements of the Set
     * with the odd length and leave elements with even
     * length
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        MapFiltering mf = new MapFiltering();
        Map<String, String> map = mf.initializeMap();
        mf.displayMap(map);
        mf.checkUniqueness(map);
    }

    /**
     * This method allows to initialize the map with values
     *
     * @return The filled map
     */
    private Map<String, String> initializeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "George");
        map.put("2", "Peter");
        map.put("5", "Michael");
        map.put("10", "Alice");
        map.put("11", "Alice");
        log.info("The map is initialized");
        return map;
    }

    /**
     * This method allows to display the set elements
     *
     * @param map The input map
     */
    private void displayMap(Map<String, String> map) {
        System.out.println(map);
        log.info("The map is displayed");
    }

    /**
     * This method allows to check if there any similar values
     * in the map or not
     *
     * @param map The input map
     * @return true, if map does not contain equal values,
     * otherwise - false
     */
    public void checkUniqueness(Map<String, String> map) {
        Collection<String> values = map.values();
        Set<String> set = new HashSet<>(values);
        if (set.size() == map.size()) {
            log.info("The map contains only unique values");
        } else {
            log.info("The map does not contain only unique values");
        }
    }
}
