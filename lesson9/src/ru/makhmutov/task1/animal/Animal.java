package ru.makhmutov.task1.animal;

import ru.makhmutov.task1.api.Fly;
import ru.makhmutov.task1.api.Run;
import ru.makhmutov.task1.api.Swim;

public abstract class Animal implements Run, Swim, Fly {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    /**
     * This is getter method for the animal name
     *
     * @return Animal name
     */
    public abstract String getName();
}
