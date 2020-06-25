package ru.makhmutov.task2;

public class ObjectCounter {

    private static int objectCount = 0;

    /**
     * Constructor of the ObjectCounter class
     */
    public ObjectCounter() {
        objectCount++;
        System.out.format("%d object(s) is/are created%n", getObjectCount());
    }

    /**
     * This method is a getter, which returns number of created objects
     *
     * @return Number of created objects
     */
    private static int getObjectCount() {
        return objectCount;
    }

    /**
     * The entry point of the ObjectCounter program.
     * It generates 10 objects and prints the count
     * of currently created objects
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ObjectCounter oc = new ObjectCounter();
        }
    }
}
