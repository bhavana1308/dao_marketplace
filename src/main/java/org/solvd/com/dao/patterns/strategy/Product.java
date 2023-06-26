package org.solvd.com.dao.patterns.strategy;

public class Product {

    private final String name;

    private final double price;

    private DiscountStrategy discountStrategy;

    public Product(String name, double price, DiscountStrategy discountStrategy) {
        this.name = name;
        this.price = price;
        this.discountStrategy = discountStrategy;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double applyDiscount() {
        return discountStrategy.applyDiscount(price);
    }
}
