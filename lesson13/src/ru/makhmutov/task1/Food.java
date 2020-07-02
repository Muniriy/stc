package ru.makhmutov.task1;

public enum Food {
    CARROT("Морковь"),
    APPLE("Яблоко"),
    PORRIDGE("Овсянка"),
    MUSHROOM_SOUP("Грибной суп"),
    CAESAR_SALAD("Салат цезарь");

    private final String name;

    Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
