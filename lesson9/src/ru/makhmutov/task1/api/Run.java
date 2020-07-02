package ru.makhmutov.task1.api;

import ru.makhmutov.task1.exceptions.CannotRunException;

public interface Run {

    /**
     * This methods allows to start running
     */
    default void startRunning() throws CannotRunException {
        throw new CannotRunException("Not possible to start running because of no ability to run");
    }

    /**
     * This methods allows to stop running
     */
    default void stopRunning() throws CannotRunException {
        throw new CannotRunException("Not possible to stop running because of no ability to run");
    }
}
