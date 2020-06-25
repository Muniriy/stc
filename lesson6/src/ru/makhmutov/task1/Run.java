package ru.makhmutov.task1;

import ru.makhmutov.task1.employee.Assistant;
import ru.makhmutov.task1.employee.Employee;
import ru.makhmutov.task1.employee.Instructor;

import java.util.*;

public class Run {

    private static final int MINIMAL_STRING_LENGTH = 2;
    private static int employeeNumber = 0;

    /**
     * This method allows to hire employees of different
     * type by scanning values for each of them
     *
     * @param employeeType The string, which defines the type of employee.
     *                     It is assumed that there are 2 types:
     *                     instructor and assistant
     */
    private static void hireEmployee(String employeeType, Run run, List<Employee> employees, Scanner scanner) {
        char[] existingGenders = new char[3];
        existingGenders[0] = 'm';
        existingGenders[1] = 'f';
        existingGenders[2] = 'n';
        final float minimalSalary = 12000F;
        char[] answers = new char[2];
        answers[0] = 'y';
        answers[1] = 'n';
//        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
//        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        int id = ++employeeNumber;
        String name = run.scan(scanner, "name of the " + employeeType);
        String surname = run.scan(scanner, "surname of the " + employeeType);
        char gender = run.scan(scanner, "the gender of the " + employeeType, existingGenders);
        float salary = run.scan(scanner, "salary for the " + employeeType, minimalSalary);
        switch (employeeType) {
            case "instructor":
                float hirshIndex = run.scan(scanner, "h-index of the " + employeeType, 0F);
                Instructor instructor = new Instructor(id, name, surname, gender, salary, hirshIndex);
                employees.add(instructor);
                break;
            case "assistant":
                boolean englishSpeaker;
                englishSpeaker = run.scan(scanner, "'y' if " + employeeType + " speaks English. Otherwise type 'n'", answers) == 'y';
                Assistant assistant = new Assistant(id, name, surname, gender, salary, englishSpeaker);
                employees.add(assistant);
                break;
            default:
                System.out.println("Non-existent type of employee");
        }
    }

    /**
     * The entry point of the University program.
     * The program creates ArrayList with 2 employees,
     * asks to insert values to hire them, displays the results
     * and then fires the employee with ID=1. Then it
     * displays the employees left
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        Run run = new Run();
        int employeeNumber = 2;
        List<Employee> employees = new ArrayList<>(employeeNumber);
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            hireEmployee("instructor", run, employees, scanner);
            hireEmployee("assistant", run, employees, scanner);
        }
        run.displayEmployees(employees);
        run.fireEmployee(employees, 1);
        run.displayEmployees(employees);
    }

    /**
     * This method allows to fire employees by ID
     *
     * @param employees The array with all employees
     * @param id        The ID of the employee to fire
     */
    private void fireEmployee(List<Employee> employees, int id) {
        if (id > 0 && id <= employeeNumber) {
            System.out.format("University employee with ID equal %d was fired: ", id);
            employees.removeIf(nextEmployee -> nextEmployee.getId() == id);
        } else {
            System.out.println("Firing of non-existent employee");
        }
    }

    /**
     * This method displays all employees and their data
     *
     * @param employees The array of all employees
     */
    private void displayEmployees(List<Employee> employees) {
        System.out.println();
        System.out.println("All university employees:");
        for (Employee employee : employees) {
            System.out.println();
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Surname: " + employee.getSurname());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Salary: " + employee.getSalary());
            if (employee instanceof Instructor) {
                System.out.println("The class is Instructor");
                System.out.println("h-index: " + ((Instructor) employee).getHirshIndex());
            } else if (employee instanceof Assistant) {
                System.out.println("The class is Assistant");
                System.out.println("Speaks English: " + ((Assistant) employee).isEnglishSpeaker());
            }
            System.out.println();
        }
    }

    /**
     * This methods returns true if the string consists
     * of only English alphabet letters and begins with
     * the capital letter
     *
     * @param name the input String
     * @return true or false
     */
    public boolean isAlphabetSymbol(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    /**
     * This method allows to read valid input String values.
     *
     * @param scanner   The object of Scanner class needed for scanning the number
     * @param inputType The string which defines the name of the value
     * @return The obtained value received via scanning
     */
    private String scan(Scanner scanner, String inputType) {
        String value;
        boolean validityFlag = false;
        System.out.print("\nType the " + inputType + ": ");
        do {
            value = scanner.next();
            if (isAlphabetSymbol(value) && value.length() >= MINIMAL_STRING_LENGTH) {
                validityFlag = true;
            } else {
                System.out.format("\nUse strings containing not less than %d English alphabet symbols" +
                        "\nand beginning with capital letter, try one more time: ", MINIMAL_STRING_LENGTH);
            }
        } while (!validityFlag);
        return value;
    }

    /**
     * This method allows to read valid input char values.
     *
     * @param scanner        The object of Scanner class needed for scanning the number
     * @param inputType      The string which defines the name of the value
     * @param allowedSymbols The char array with set of allowed input symbols
     * @return The obtained value received via scanning
     */
    private char scan(Scanner scanner, String inputType, char[] allowedSymbols) {
        char value;
        boolean validityFlag = false;
        System.out.print("\nType " + inputType + " (");
        for (char c : allowedSymbols) {
            System.out.print(c + "/");
        }
        System.out.print(") ");
        do {
            value = scanner.next().charAt(0);
            for (char symbol : allowedSymbols) {
                if (value == symbol) {
                    validityFlag = true;
                    break;
                }
            }
            if (!validityFlag) {
                System.out.print("\nUse only allowed symbols (");
                for (char allowedSymbol : allowedSymbols) {
                    System.out.print(allowedSymbol + "/");
                }
                System.out.print("), try one more time: ");
            }
        } while (!validityFlag);
        return value;
    }

    /**
     * This method allows to read valid input float values.
     *
     * @param scanner       The object of Scanner class needed for scanning the number
     * @param inputType     The string which defines the name of the value
     * @param lowerBoundary The lower boundary for input value
     * @return The obtained value received via scanning
     */
    private float scan(Scanner scanner, String inputType, float lowerBoundary) {
        float value = -1;
        boolean validityFlag;
        System.out.print("\nType the " + inputType + ": ");
        do {
            try {
                value = scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                validityFlag = false;
                scanner.next();
                continue;
            }
            if (value < lowerBoundary) {
                System.out.format("%nPlease enter the number not lower than %f: ", lowerBoundary);
                validityFlag = false;
            } else {
                validityFlag = true;
            }
        } while (!validityFlag);
        return value;
    }
}
