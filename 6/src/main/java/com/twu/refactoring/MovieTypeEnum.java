package com.twu.refactoring;

/**
 * @Auto Jiang Yuzhou
 * @Date 2020/8/4 0:02
 * @Description ***
 **/
public enum MovieTypeEnum {
    Regular {
        @Override
        public double getAmount(int daysRented) {
            double thisAmount = 0;
            thisAmount += ConstantNum.REGULAR_ADDITION_DAYS_RENTED;
            if (daysRented > ConstantNum.REGULAR_ADDITION_DAYS_RENTED)
                thisAmount += (daysRented - ConstantNum.REGULAR_ADDITION_DAYS_RENTED) * ConstantNum.REGULAR_ADDITION_PRICE;

            return thisAmount;
        }
    },
    Childrens {
        @Override
        public double getAmount(int daysRented) {
            double thisAmount = 0;
            thisAmount += ConstantNum.CHILDRENS_NORMAL_PRICE;
            if (daysRented > ConstantNum.CHILDRENS_ADDITION_DAYS_RENTED)
                thisAmount += (daysRented - ConstantNum.CHILDRENS_ADDITION_DAYS_RENTED) * ConstantNum.CHILDRENS_ADDITION_PRICE;
            return thisAmount;
        }
    },
    NewRelease {
        @Override
        public double getAmount(int daysRented) {
            double thisAmount = 0;
            thisAmount += daysRented * ConstantNum.NEW_RELEASE_NORMAL_PRICE;
            return thisAmount;
        }
    };

    public abstract double getAmount(int daysRented);
}
