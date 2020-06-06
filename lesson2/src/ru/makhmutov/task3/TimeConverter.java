package ru.makhmutov.task3;

public class TimeConverter {

    /**
     * The entry point of the TimeConverter program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            int seconds = Integer.parseInt(args[0]);
            if (seconds >= 0) {
                int minInHour = 60;
                int secInMin = 60;
                float hours = (float) seconds / secInMin / minInHour;
                System.out.println("\n" + seconds + " second(s) is equal to " + hours + " hour(s)");
            } else System.out.println("The value has to be not less than 0");
        } else System.out.println("The amount of seconds has to be defined by the argument");
    }
}
