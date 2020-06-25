package ru.makhmutov.task1.human;

public class Armenian extends Human {

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!isRuns()) {
            setRuns(true);
            System.out.println("Armenian started running");
        } else {
            System.out.println("Armenian already runs");
        }
    }

    /**
     * This methods allows to stop running
     */
    @Override
    public void stopRunning() {
        if (isRuns()) {
            setRuns(false);
            System.out.println("Armenian stopped running");
        } else {
            System.out.println("Armenian already doesn't run");
        }
    }

    /**
     * This methods allows to start swimming
     */
    @Override
    public void startSwimming() {
        if (!isSwims()) {
            setSwims(true);
            System.out.println("Armenian started swimming");
        } else {
            System.out.println("Armenian already swims");
        }
    }

    /**
     * This methods allows to stop swimming
     */
    @Override
    public void stopSwimming() {
        if (isSwims()) {
            setSwims(false);
            System.out.println("Armenian stopped swimming");
        } else {
            System.out.println("Armenian already doesn't swim");
        }
    }
}
