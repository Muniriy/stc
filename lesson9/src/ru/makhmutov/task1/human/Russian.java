package ru.makhmutov.task1.human;

public class Russian extends Human {

    private boolean runs = false;
    private boolean swims = false;

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!runs) {
            runs = true;
            System.out.println("Russian started running");
        } else {
            System.out.println("Russian already runs");
        }
    }

    /**
     * This methods allows to stop running
     */
    @Override
    public void stopRunning() {
        if (runs) {
            runs = false;
            System.out.println("Russian stopped running");
        } else {
            System.out.println("Russian already doesn't run");
        }
    }

    /**
     * This methods allows to start swimming
     */
    @Override
    public void startSwimming() {
        if (!swims) {
            swims = true;
            System.out.println("Russian started swimming");
        } else {
            System.out.println("Russian already swims");
        }
    }

    /**
     * This methods allows to stop swimming
     */
    @Override
    public void stopSwimming() {
        if (swims) {
            swims = false;
            System.out.println("Russian stopped swimming");
        } else {
            System.out.println("Russian already doesn't swim");
        }
    }
}
