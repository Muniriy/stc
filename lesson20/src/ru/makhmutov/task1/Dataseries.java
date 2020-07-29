package ru.makhmutov.task1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dataseries {
    private int timepoint;
    private int cloudcover;
    private int seeing;
    private int transparency;

    @JsonProperty("lifted_index")
    private int liftedIndex;

    private int rh2m;
    private int temp2m;

    /**
     * This is the getter for the time point
     *
     * @return The time point
     */
    public int getTimepoint() {
        return timepoint;
    }

    /**
     * This is the getter for the time point
     */
    public void setTimepoint(int timepoint) {
        this.timepoint = timepoint;
    }

    /**
     * This is the getter for the cloud cover
     *
     * @return The cloud cover
     */
    public int getCloudcover() {
        return cloudcover;
    }

    /**
     * This is the setter for the cloud cover
     */
    public void setCloudcover(int cloudcover) {
        this.cloudcover = cloudcover;
    }

    /**
     * This is the getter for the seeing
     *
     * @return The seeing
     */
    public int getSeeing() {
        return seeing;
    }

    /**
     * This is the setter for the seeing
     */
    public void setSeeing(int seeing) {
        this.seeing = seeing;
    }

    /**
     * This is the getter for the transparency
     *
     * @return The transparency
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * This is the setter for the transparency
     */
    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    /**
     * This is the getter for the lifted index
     *
     * @return The lifted index
     */
    public int getLiftedIndex() {
        return liftedIndex;
    }

    /**
     * This is the setter for the lifted index
     */
    public void setLiftedIndex(int liftedIndex) {
        this.liftedIndex = liftedIndex;
    }

    /**
     * This is the getter for the 2 meter relative humidity
     *
     * @return The 2 meter relative humidity
     */
    public int getRh2m() {
        return rh2m;
    }

    /**
     * This is the getter for the 2 meter relative humidity
     */
    public void setRh2m(int rh2m) {
        this.rh2m = rh2m;
    }

    /**
     * This is the getter for the 2 meter temperature
     *
     * @return The 2 meter temperature
     */
    public int getTemp2m() {
        return temp2m;
    }

    /**
     * This is the getter for the 2 meter temperature
     */
    public void setTemp2m(int temp2m) {
        this.temp2m = temp2m;
    }
}
