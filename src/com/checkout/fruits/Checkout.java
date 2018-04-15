package com.checkout.fruits;

import static com.checkout.fruits.ScannerUtils.readIntegerInput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Checkout {

	private int noOfApples = 0;
	private int noOfOranges = 0;

	public void buyFruits() {
		
		try(Scanner reader = new Scanner(System.in)) {
			log("Welcome to Fruits Checkout app.. \n");
			log("Available fruits(Price) \n 1. Apple (0.60p) \n 2. Orange (0.25p)");

			log("\nPlease Enter the apples quantity: ");
			noOfApples = readIntegerInput(reader);
			log("Please Enter the Oranges quantity: ");
			noOfOranges = readIntegerInput(reader);

			checkout();
		} catch(Exception e) {
			//e.printStackTrace();
			log("Error has occured in buyFruits()" +e.getMessage());
		} 
	}

	private void checkout() {

		double totalAmount = 0;
		
		if(checkSpecialOffer()) {
			totalAmount = getDiscountedTotalPrice();
		} else {
			totalAmount = getTotalAmount();
		}
		
		BigDecimal totalVal = new BigDecimal(totalAmount);
		BigDecimal displayTotalVal = totalVal.setScale(2, RoundingMode.HALF_EVEN);
		
		log("Apples: " + noOfApples + " Oranges: " + noOfOranges);
		log("Thank you for shopping..\nYour Total Amount is: "+ displayTotalVal);
	}

	private double getDiscountedTotalPrice() {
		double appleCost = 0;
		double orangeCost = 0;

		try {
			if(noOfApples > 0) {
				appleCost = noOfApples * (FruitsConstants.APPLE_COST / 2);
				//log("apple discount price: " + appleCost);
			} if(noOfOranges > 0) {
				orangeCost = noOfOranges * (FruitsConstants.ORANGE_COST / 1.5);
				//log("orange discount price: " + orangeCost);
			}
		}catch(Exception e) {
			log("Error has occured while calculating the price");
		}

		return appleCost + orangeCost;
	}

	private boolean checkSpecialOffer() {
		
		//log("please check for special offers before checkout.. \nPress 1 to see offers \nPress any number to checkout");
		
		if(noOfApples >= 1 && noOfOranges >= 3) {
			return true;
		}
		return false;
	}

	private double getTotalAmount() {
		return (noOfApples * FruitsConstants.APPLE_COST) + (noOfOranges * FruitsConstants.ORANGE_COST);
	}

	private void log(String msg) {
		System.out.println(msg);
	}
}
