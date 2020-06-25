package ru.makhmutov.task1;

import ru.makhmutov.task1.animal.Duck;
import ru.makhmutov.task1.human.Armenian;

public class Main {

    /**
     * The entry point of the Human And Animals program.
     * Duck is tested for different actions provided by interface
     * and overwritten inside Duck class.
     * Armenian is tested for different actions provided by interface
     * and overwritten inside Armenian class.
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Duck duck = new Duck();
        System.out.println(duck.getName());
        duck.startFlying();
        duck.stopFlying();
        duck.startRunning();
        duck.startRunning();
        duck.stopRunning();
        duck.stopSwimming();

        System.out.println();

        Armenian armenian = new Armenian();
        armenian.startRunning();
        armenian.stopRunning();
        armenian.stopSwimming();
    }
}
