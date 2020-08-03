package com.twu.refactoring;

import java.util.function.Predicate;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countInMultipleSense(num -> num % 2 == 0);
    }

    public int countOdd() {
        return countInMultipleSense(num -> num % 2 == 1);
    }

    public int countPositive() {
        return countInMultipleSense(num -> num >= 0);
    }

    public int countNegative() {
        return countInMultipleSense(num -> num < 0);
    }

    private int countInMultipleSense(Predicate<Integer> predicate) {
        int count = 0;
        for (int number : numbers) {
            if (predicate.test(number))
                count++;
        }
        return count;
    }
}
