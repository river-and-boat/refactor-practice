package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {

	private static final double SALE_TAX_RATE = 0.10;

    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append("======Printing Orders======\n");

		// print date, bill no, customer name
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());

		// prints lineItems
		double totalSalesTax = 0d;
		double totalAmounts = 0d;
		for (LineItem lineItem : o.getLineItems()) {
			output.append(lineItem.toString());
            double salesTax = lineItem.totalAmount() * SALE_TAX_RATE;
			totalSalesTax += salesTax;
			totalAmounts += lineItem.totalAmount() + salesTax;
		}
		output.append("Sales Tax").append('\t').append(totalSalesTax);
		output.append("Total Amount").append('\t').append(totalAmounts);
		return output.toString();
	}
}