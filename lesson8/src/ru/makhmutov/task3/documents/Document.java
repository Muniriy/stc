package ru.makhmutov.task3.documents;

import java.util.Calendar;

public abstract class Document {
    private final int id;
    private final Calendar date;
    private final String[] goods;

    public Document(int id, Calendar date, String[] goods) {
        this.id = id;
        this.date = date;
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public Calendar getDate() {
        return date;
    }

    public String[] getGoods() {
        return goods;
    }
}
