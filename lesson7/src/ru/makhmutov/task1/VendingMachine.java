package ru.makhmutov.task1;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachine {

    private int insertedMoney = 0;

    /**
     * The entry point of the Vending Machine program.
     * The program allows to see the menu, insert the money
     * and make a purchase
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
            boolean purchaseCompleted;
            do {
                vm.seeMenu();
                boolean insertionCompleted;
                boolean firstChoice = true;
                do {
                    vm.insertMoney(scanner, firstChoice);
                    insertionCompleted = vm.buyDrink(scanner);
                    firstChoice = false;
                } while (!insertionCompleted);
                purchaseCompleted = vm.completePurchase(scanner);
            } while (!purchaseCompleted);
        }
    }

    /**
     * This method allows to read valid input char values.
     *
     * @param scanner The object of Scanner class needed for scanning the number
     * @return The obtained value received via scanning
     */
    private boolean scanChar(Scanner scanner) {
        char value;
        do {
            value = scanner.next().charAt(0);
            if (value != 'y' && value != 'n') {
                System.out.print("\nType only 'y' or 'n', try one more time: ");
            }
        } while (value != 'y' && value != 'n');
        return (value != 'y');
    }

    /**
     * This method allows to read valid input values.
     * The number has to be integer
     *
     * @return The obtained value received via scanning
     */
    private int scanNumber(Scanner scanner, String type) {
        double value = 0.5; // the initial value should not be integer to be a barrier for the program
        boolean inserted = false;
        do {
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("\nDo not enter characters, try one more time: ");
                scanner.next();
                continue;
            }
            if (type.equals("money")) {
                for (Money money : Money.values()) {
                    if (value == money.getDenomination()) {
                        inserted = true;
                        break;
                    }
                }
            } else if (type.equals("vending machine items")) {
                for (Machine machine : Machine.values()) {
                    if (value == (machine.ordinal() + 1)) {
                        inserted = true;
                        break;
                    }
                }
            }
            if (!inserted) {
                System.out.format("%nPlease insert applicable %s: ", type);
            }

        } while (!inserted);
        return (int) value;
    }

    /**
     * This method displays all existing items of vending machine
     * with their numbers and prices
     */
    private void seeMenu() {
        System.out.println("The menu is:");
        for (Machine machine : Machine.values()) {
            System.out.printf("%d. %9s - %d₽%n", (machine.ordinal() + 1), machine.getName(), machine.getPrice());
        }
    }

    /**
     * This method allows to insert the money into the vending machine
     *
     * @param scanner     The object of Scanner class needed for scanning
     *                    customer's answers
     * @param firstChoice true - if the first series of money insertions for the exact drink
     *                    false - if NOT the first series of money insertions for the exact drink
     */
    private void insertMoney(Scanner scanner, boolean firstChoice) {
        boolean insertionUnnedeed = false;
        if (insertedMoney > 0 && firstChoice) {
            System.out.print("Would you like to add more money? (y/n): ");
            insertionUnnedeed = scanChar(scanner);
        }
        if (!insertionUnnedeed) {
            boolean insertionCompleted;
            do {
                System.out.print("Please insert the money. Use only coins and banknotes of ");
                for (Money money : Money.values()) {
                    System.out.print(money.getDenomination() + " ");
                }
                System.out.print("denomination: ");
                insertedMoney += scanNumber(scanner, "money");
                System.out.print("Totally you inserted " + insertedMoney + "₽. Would you like to insert more money? (y/n): ");
                insertionCompleted = scanChar(scanner);
            } while (!insertionCompleted);
        }
    }

    /**
     * This method allows to make purchase of drinks
     * from the vending machine
     *
     * @param scanner The object of Scanner class needed for scanning
     *                customer's answers
     * @return true - if money insertion is completed,
     * false - if money insertion is NOT completed
     */
    private boolean buyDrink(Scanner scanner) {
        boolean insertionCompleted = true;
        boolean drinkChosen = true;
        do {
            System.out.print("Choose the item from the menu by typing its number: ");
            int drinkItem = scanNumber(scanner, "vending machine items");
            for (Machine machine : Machine.values()) {
                if ((machine.ordinal() + 1) == drinkItem) {
                    if (insertedMoney < machine.getPrice()) {
                        System.out.println("Not enough money. Insert more or choose another drink");
                        System.out.print("Would you like to insert more money? (y/n): ");
                        insertionCompleted = scanChar(scanner);
                        if (!insertionCompleted) {
                            break;
                        } else {
                            System.out.print("Would you like to choose another drink? (y/n): ");
                            drinkChosen = scanChar(scanner);
                            if (!drinkChosen) {
                                break;
                            }
                        }
                    } else {
                        insertedMoney -= machine.getPrice();
                        System.out.println("Please take your " + machine.getName());
                    }
                }
            }
        } while (insertionCompleted && !drinkChosen);
        return insertionCompleted;
    }

    /**
     * This method is called to complete the purchase
     * and ask if the customer would like to buy more drinks
     *
     * @param scanner The object of Scanner class needed for scanning
     *                customer's answers
     * @return true - if purchase is completed
     * false - if purchase is NOT completed
     */
    private boolean completePurchase(Scanner scanner) {
        boolean purchaseCompleted;
        if (insertedMoney > 0) {
            System.out.format("You have %d₽ left. Would you like to buy more drinks? (y/n): ", insertedMoney);
        } else {
            System.out.print("Would you like to buy more drinks? (y/n): ");
        }
        purchaseCompleted = scanChar(scanner);
        if (purchaseCompleted) {
            insertedMoney = 0;
            System.out.println("Thank you! Come back later!");
        }
        return purchaseCompleted;
    }
}
