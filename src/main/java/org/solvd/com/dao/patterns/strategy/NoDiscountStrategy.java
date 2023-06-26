package org.solvd.com.dao.patterns.strategy;

public class NoDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
