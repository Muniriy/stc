package ru.makhmutov.task1;

import java.util.Locale;
import java.util.Scanner;

public class Petrol {

	/**
	 * The entry point of the Petrol program
	 *
	 * @param args Array with parameters of the program
	 */
	public static void main(String[] args) {
		Petrol p = new Petrol();
		float price = p.scanNumber("price");
		float amount = p.scanNumber("amount");
		float cost = price * amount;
		System.out.println("\nThe cost of petrol is " + cost + " Roubles");
	}

	/**
	 * This method allows to read valid input values
	 *
	 * @param name The name of value type
	 * @return The obtained value received via scanning
	 */
	private float scanNumber(String name) {
		Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
		System.out.print("\nType the " + name + " of petrol (apply dot for mantissa if needed): ");
		float value;
		do {
			value = scanner.nextFloat();
			if (value <= 0)
				System.out.print("\nPlease enter the positive number for the " + name + " of petrol: ");
		} while (value <= 0);
		return value;
	}
}
