package ru.makhmutov.task1.human;

public class Russian extends Human {

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!isRuns()) {
            setRuns(true);
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
        if (isRuns()) {
            setRuns(false);
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
        if (!isSwims()) {
            setSwims(true);
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
        if (isSwims()) {
            setSwims(false);
            System.out.println("Russian stopped swimming");
        } else {
            System.out.println("Russian already doesn't swim");
        }
    }
}
