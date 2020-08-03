package com.twu.refactoring;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 22:21
 * @Description ***
 **/
public class RegularMovie extends Movie {

    private static final int REGULAR_ADDITION_DAYS_RENTED = 2;

    private static final double REGULAR_ADDITION_PRICE = 1.5;


    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        thisAmount += REGULAR_ADDITION_DAYS_RENTED;
        if (daysRented > REGULAR_ADDITION_DAYS_RENTED)
            thisAmount += (daysRented - REGULAR_ADDITION_DAYS_RENTED) * REGULAR_ADDITION_PRICE;

        return thisAmount;
    }
}
