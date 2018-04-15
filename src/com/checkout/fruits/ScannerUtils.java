package com.checkout.fruits;

import java.util.Scanner;

public class ScannerUtils {

	public static int readIntegerInput(Scanner reader) {

		String input = null;
		int quantity = 0;

		while(input == null)
		{
			input = reader.nextLine();
			try {
				quantity = Integer.valueOf(input);
				break;
			}catch(NumberFormatException e){
				System.out.println("Invalid input, please try again");
				input = null;
			}
		}

		return quantity;
	}
}
