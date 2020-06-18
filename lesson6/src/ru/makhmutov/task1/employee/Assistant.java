package ru.makhmutov.task1.employee;

public class Assistant extends Employee {

    private boolean englishSpeaker;

    public Assistant(int id, String name, String surname, char gender, double salary, boolean englishSpeaker) {
        super(id, name, surname, gender, salary);
        this.englishSpeaker = englishSpeaker;
    }

    public boolean isEnglishSpeaker() {
        return englishSpeaker;
    }

    public void setEnglishSpeaker(boolean englishSpeaker) {
        this.englishSpeaker = englishSpeaker;
    }
}
