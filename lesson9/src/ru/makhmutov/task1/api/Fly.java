package ru.makhmutov.task1.api;

import ru.makhmutov.task1.exceptions.CannotFlyException;

public interface Fly {

    /**
     * This methods allows to start flying
     */
    default void startFlying() throws CannotFlyException {
        throw new CannotFlyException("Not possible to start flying because of no ability to fly");
    }

    /**
     * This methods allows to stop flying
     */
    default void stopFlying() throws CannotFlyException {
        throw new CannotFlyException("Not possible to stop flying because of no ability to fly");
    }
}
