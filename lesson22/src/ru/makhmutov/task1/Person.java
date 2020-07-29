package ru.makhmutov.task1;

public class Person {
    private final String name;
    private final int age;

    /**
     * This is the constructor for the Person class
     *
     * @param name The person name
     * @param age  The person age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * This is the getter for the person name
     *
     * @return The person name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the getter for the person age
     *
     * @return The person age
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Person called %s is %d years old", name, age);
    }
}
