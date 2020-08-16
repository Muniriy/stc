package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class PersonHashmap {
    private static final Logger log = LogManager.getLogger(PersonHashmap.class);

    /**
     * The entry point of PersonHashmap program.
     * This program allows to add people to the map
     * and delete duplicates from the map if any exists
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Map<String, Person> map = createMap();
        displayMap(map);
        removeTheDuplicates(map);
        displayMap(map);
    }

    /**
     * This method allows to create the map with people
     *
     * @return The map with people
     */
    public static Map<String, Person> createMap() {
        Map<String, Person> book = new HashMap<>();
        Person person1 = new Person(29, "Петрова", "жен");
        Person person2 = new Person(34, "Сидорова", "жен");
        Person person3 = new Person(34, "Тихонова", "жен");
        Person person4 = new Person(35, "Петров", "муж");
        book.put("Key1", person1);
        book.put("Key2", person1);
        book.put("Key7", person3);
        book.put("Key3", person2);
        book.put("Key4", person3);
        book.put("Key5", person4);
        book.put("Key6", person4);
        book.put("Key8", person3);
        book.put("Key9", person3);
        return book;
    }

    /**
     * This method allows to display all people from the map
     *
     * @param map The map with people
     */
    private static void displayMap(Map<String, Person> map) {
        System.out.println(map);
        log.info("The map is displayed");
    }

    /**
     * This method allows to remove the duplicates from the map
     * by using method removeItemFromMapByValue(...)
     *
     * @param map The map with people
     */
    public static void removeTheDuplicates(Map<String, Person> map) {
        Collection<Person> values = map.values();
        Set<Person> set = new HashSet<>(values);
        if (set.size() == map.size()) {
            log.info("The map contains only unique people");
        } else {
            ArrayList<Person> forDeletion = new ArrayList<>();
            List<Person> list = new ArrayList<>(map.values());
            for (Person person : list) {
                if (!forDeletion.contains(person)) {
                    int duplicates = Collections.frequency(list, person) - 1;
                    if (duplicates > 0) {
                        for (int i = 0; i < duplicates; i++) {
                            forDeletion.add(person);
                        }
                    }
                }
            }
            for (Person person : forDeletion) {
                removeItemFromMapByValue(map, person);
            }
            log.info("The duplicates are deleted");
        }
    }

    /**
     * This method allows to remove duplicated items from map
     * by its value
     *
     * @param map   The map with people
     * @param value The value which should be deleted
     */
    public static void removeItemFromMapByValue(Map<String, Person> map, Person value) {
        Map<String, Person> copy = new HashMap<>(map);
        for (Map.Entry<String, Person> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
                break;
            }
        }
    }
}
