package ru.makhmutov.task3.documents;

import java.time.LocalDate;

public class Contract extends Document {

    /**
     * Constructor for Contract class
     *
     * @param id    Contract ID
     * @param date  Date of contract creation
     * @param goods Array of goods from contract
     */
    public Contract(int id, LocalDate date, String[] goods) {
        super(id, date, goods);
    }

}
