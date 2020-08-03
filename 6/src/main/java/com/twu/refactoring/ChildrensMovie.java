package com.twu.refactoring;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 22:18
 * @Description ***
 **/
public class ChildrensMovie extends Movie {

    private static final int CHILDRENS_ADDITION_DAYS_RENTED = 3;

    private static final double CHILDRENS_ADDITION_PRICE = 1.5;

    private static final double CHILDRENS_NORMAL_PRICE = 1.5;

    public ChildrensMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        thisAmount += CHILDRENS_NORMAL_PRICE;
        if (daysRented > CHILDRENS_ADDITION_DAYS_RENTED)
            thisAmount += (daysRented - CHILDRENS_ADDITION_DAYS_RENTED) * CHILDRENS_ADDITION_PRICE;
        return thisAmount;
    }
}
