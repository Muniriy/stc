package ru.makhmutov.task1.animal;

import ru.makhmutov.task1.Fly;
import ru.makhmutov.task1.Run;
import ru.makhmutov.task1.Swim;

public class Duck extends Animal implements Fly, Swim, Run {

    private boolean runs = false;
    private boolean swims = false;
    private boolean flies = false;

    /**
     * This is getter method for the animal name
     *
     * @return Animal name
     */
    @Override
    public String getName() {
        return "Duck";
    }

    /**
     * This methods allows to start flying
     */
    @Override
    public void startFlying() {
        if (!flies) {
            flies = true;
            System.out.println("The Duck started flying");
        } else {
            System.out.println("The Duck already flies");
        }
    }

    /**
     * This methods allows to stop flying
     */
    @Override
    public void stopFlying() {
        if (flies) {
            flies = false;
            System.out.println("The Duck stopped flying");
        } else {
            System.out.println("The Duck already doesn't fly");
        }
    }

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!runs) {
            runs = true;
            System.out.println("The Duck started running");
        } else {
            System.out.println("The Duck already runs");
        }
    }

    /**
     * This methods allows to stop running
     */
    @Override
    public void stopRunning() {
        if (runs) {
            runs = false;
            System.out.println("The Duck stopped running");
        } else {
            System.out.println("The Duck already doesn't run");
        }
    }

    /**
     * This methods allows to start swimming
     */
    @Override
    public void startSwimming() {
        if (!swims) {
            swims = true;
            System.out.println("The Duck started swimming");
        } else {
            System.out.println("The Duck already swims");
        }
    }

    /**
     * This methods allows to stop swimming
     */
    @Override
    public void stopSwimming() {
        if (swims) {
            swims = false;
            System.out.println("The Duck stopped swimming");
        } else {
            System.out.println("The Duck already doesn't swim");
        }
    }
}
