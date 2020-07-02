package ru.makhmutov.task1.api;

import ru.makhmutov.task1.exceptions.CannotSwimException;

public interface Swim {

    /**
     * This methods allows to start swimming
     */
    default void startSwimming() throws CannotSwimException {
        throw new CannotSwimException("Not possible to start swimming because of no ability to swim");
    }

    /**
     * This methods allows to stop swimming
     */
    default void stopSwimming() throws CannotSwimException {
        throw new CannotSwimException("Not possible to stop swimming because of no ability to swim");
    }
}
