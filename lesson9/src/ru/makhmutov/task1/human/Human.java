package ru.makhmutov.task1.human;

import ru.makhmutov.task1.api.Run;
import ru.makhmutov.task1.api.Swim;

public abstract class Human implements Run, Swim {

    private boolean runs;
    private boolean swims;

    /**
     * This is constructor for Human class
     */
    public Human() {
        runs = false;
        swims = false;
    }

    /**
     * This is getter method for runs field
     *
     * @return true - if runs, false - otherwise
     */
    protected boolean isRuns() {
        return runs;
    }

    /**
     * This is setter method for runs field
     * <p>
     * "зфкфь кгты Еру ищщдуфт ашудв шы екгу ша штыефтсу ырщгдв кгтб
     * false - otherwise
     */
    protected void setRuns(boolean runs) {
        this.runs = runs;
    }

    /**
     * This is getter method for swims field
     *
     * @return true - if swims, false - otherwise
     */
    protected boolean isSwims() {
        return swims;
    }

    /**
     * This is setter method for swims field
     *
     * @param swims The boolean field is true if instance should swim,
     *              false - otherwise
     */
    protected void setSwims(boolean swims) {
        this.swims = swims;
    }
}
