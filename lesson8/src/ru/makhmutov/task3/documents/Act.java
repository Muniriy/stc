package ru.makhmutov.task3.documents;

import java.time.LocalDate;

public class Act extends Document {

    private final int actID;

    /**
     * Constructor for Act class
     *
     * @param id    Contract ID
     * @param date  Date of act creation
     * @param goods Array of goods from contract
     * @param actID Act ID
     */
    public Act(int id, LocalDate date, String[] goods, int actID) {
        super(id, date, goods);
        this.actID = actID;
    }

    /**
     * This is getter method for act ID
     *
     * @return Act ID
     */
    public int getActID() {
        return actID;
    }
}
