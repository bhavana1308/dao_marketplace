package org.solvd.com.dao.patterns.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {

    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        double discountAmount = price * percentage;
        return price - discountAmount;
    }
}
