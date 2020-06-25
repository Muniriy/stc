package ru.makhmutov.task3.documents;

import java.util.Calendar;

public class Act extends Document {

    private final int actID;

    public Act(int id, Calendar date, String[] goods, int actID) {
        super(id, date, goods);
        this.actID = actID;
    }

    public int getActID() {
        return actID;
    }
}
