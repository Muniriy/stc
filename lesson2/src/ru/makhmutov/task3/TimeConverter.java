package ru.makhmutov.task3;

public class TimeConverter {

    private final static int minInHour = 60;
    private final static int secInMin = 60;

    /**
     * The entry point of the TimeConverter program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            float seconds = Float.parseFloat(args[0]);
            if (seconds >= 0) {
                float hours = seconds / secInMin / minInHour;
                System.out.println("\n" + seconds + " second(s) is equal to " + hours + " hour(s)");
            } else System.out.println("The value has to be not less than 0");
        } else System.out.println("The amount of seconds has to be defined by the argument");
    }
}
