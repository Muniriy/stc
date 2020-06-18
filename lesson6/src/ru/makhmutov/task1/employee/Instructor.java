package ru.makhmutov.task1.employee;

public class Instructor extends Employee {

    private float hirshIndex;

    public Instructor(int id, String name, String surname, char gender, double salary, float hirshIndex) {
        super(id, name, surname, gender, salary);
        this.hirshIndex = hirshIndex;
    }

    public float getHirshIndex() {
        return hirshIndex;
    }

    public void setHirshIndex(float hIndex) {
        this.hirshIndex = hIndex;
    }
}
