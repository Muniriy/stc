package ru.makhmutov.task1.animal;

public class Ant extends Animal {

    private boolean runs = false;

    public Ant(String name) {
        super(name);
    }

    /**
     * This is getter method for the animal name
     *
     * @return Animal name
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName().concat(" " + name);
    }

    /**
     * This methods allows to start running
     */
    @Override
    public void startRunning() {
        if (!runs) {
            runs = true;
            System.out.println("The Ant started running");
        } else {
            System.out.println("The Ant already runs");
        }
    }

    /**
     * This methods allows to stop running
     */
    @Override
    public void stopRunning() {
        if (runs) {
            runs = false;
            System.out.println("The Ant stopped running");
        } else {
            System.out.println("The Ant already doesn't run");
        }
    }
}
