package ru.makhmutov.task3.documents;

import java.util.Calendar;

public abstract class Document {
    private final int id;
    private final Calendar date;
    private final String[] goods;

    /**
     * Constructor for Document class
     *
     * @param id    Document ID
     * @param date  Date of document creation
     * @param goods Goods from document
     */
    public Document(int id, Calendar date, String[] goods) {
        this.id = id;
        this.date = date;
        this.goods = goods;
    }

    /**
     * This is getter method for document ID
     *
     * @return Document ID
     */
    public int getId() {
        return id;
    }

    /**
     * This is getter method for document creation date
     *
     * @return Date of the document creation
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * This is getter method for goods in document
     *
     * @return Array with goods from document
     */
    public String[] getGoods() {
        return goods;
    }
}
