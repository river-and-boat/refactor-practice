package com.twu.refactoring;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	private static final int REGULAR_ADDITION_DAYS_RENTED = 2;

	private static final int CHILDRENS_ADDITION_DAYS_RENTED = 3;

	private static final int NEW_RELEASE_ADDITION_DAYS_RENTED = 1;

	private static final double REGULAR_ADDITION_PRICE = 1.5;

	private static final double CHILDRENS_ADDITION_PRICE = 1.5;

	private static final double CHILDRENS_NORMAL_PRICE = 1.5;

	private static final double NEW_RELEASE_NORMAL_PRICE = 3;

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public void replaceMovie(int index, Movie arg) {
		rentalList.get(index).setMovie(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();

			// determine amounts for each line
			thisAmount += each.getMovie().getAmount(each.getDaysRented());

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > NEW_RELEASE_ADDITION_DAYS_RENTED)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

}
