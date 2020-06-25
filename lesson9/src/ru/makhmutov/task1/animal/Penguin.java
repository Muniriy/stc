package ru.makhmutov.task1.animal;

import ru.makhmutov.task1.Run;
import ru.makhmutov.task1.Swim;

public class Penguin extends Animal implements Swim, Run {

    private boolean runs = false;
    private boolean swims = false;

    /**
     * This is getter method for the animal name
     *
     * @return Animal name
     */
    @Override
    public String getName() {
        return "Penguin";
    }

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!runs) {
            runs = true;
            System.out.println("The Penguin started running");
        } else {
            System.out.println("The Penguin already runs");
        }
    }

    /**
     * This methods allows to stop running
     */
    @Override
    public void stopRunning() {
        if (runs) {
            runs = false;
            System.out.println("The Penguin stopped running");
        } else {
            System.out.println("The Penguin already doesn't run");
        }
    }

    /**
     * This methods allows to start swimming
     */
    @Override
    public void startSwimming() {
        if (!swims) {
            swims = true;
            System.out.println("The Penguin started swimming");
        } else {
            System.out.println("The Penguin already swims");
        }
    }

    /**
     * This methods allows to stop swimming
     */
    @Override
    public void stopSwimming() {
        if (swims) {
            swims = false;
            System.out.println("The Penguin stopped swimming");
        } else {
            System.out.println("The Penguin already doesn't swim");
        }
    }
}
