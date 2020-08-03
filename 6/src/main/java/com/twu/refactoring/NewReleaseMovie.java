package com.twu.refactoring;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/3 22:20
 * @Description ***
 **/
public class NewReleaseMovie extends Movie {

    private static final double NEW_RELEASE_NORMAL_PRICE = 3;

    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    @Override
    public double getAmount(int daysRented) {
        double thisAmount = 0;
        thisAmount += daysRented * NEW_RELEASE_NORMAL_PRICE;
        return thisAmount;
    }
}
