package org.solvd.com.dao.patterns.decorator;

public class BasicProduct implements Product {

    private final String description;
    private final double price;

    public BasicProduct(String description, double price) {
        this.description = description;
        this.price = price;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
