package ru.makhmutov.task1;

import ru.makhmutov.task1.animal.Animal;
import ru.makhmutov.task1.animal.Duck;
import ru.makhmutov.task1.animal.Penguin;
import ru.makhmutov.task1.human.Armenian;
import ru.makhmutov.task1.human.Human;
import ru.makhmutov.task1.human.Russian;

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
        try {
            Animal duck = new Duck("Donald");
            System.out.println(duck.getName());
            duck.startFlying();
            duck.stopFlying();
            duck.startRunning();
            duck.startRunning();
            duck.stopRunning();
            duck.stopSwimming();

            System.out.println();

            Animal penguin = new Penguin("Big Z");
            System.out.println(penguin.getName());
            penguin.startSwimming();
            penguin.stopSwimming();
            penguin.startFlying();

            System.out.println();

            Human armenian = new Armenian();
            armenian.startRunning();
            armenian.stopRunning();
            armenian.stopSwimming();

            System.out.println();

            Russian russian = new Russian();
            russian.startSwimming();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
