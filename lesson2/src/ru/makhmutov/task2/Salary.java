package ru.makhmutov.task2;

public class Salary {

    private static final float NDFL = 0.13F;

    /**
     * The entry point of the Salary program
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            float salary = Float.parseFloat(args[0]);
            if (salary > 0) {
                float salaryMinusNdfl = salary * (1 - NDFL);
                System.out.println("\nThe salary without NDFL is " + salaryMinusNdfl + " Roubles");
            } else System.out.println("The value has to be greater than 0");
        } else System.out.println("The salary has to be defined by the argument");
    }
}
