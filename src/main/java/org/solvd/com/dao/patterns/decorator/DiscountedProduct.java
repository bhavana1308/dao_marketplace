package org.solvd.com.dao.patterns.decorator;

public class DiscountedProduct extends ProductDecorator {

    private final double discountPercentage;

    public DiscountedProduct(Product decoratedProduct, double discountPercentage) {
        super(decoratedProduct);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        double discountedPrice = decoratedProduct.getPrice() * (1 - discountPercentage);
        return Math.round(discountedPrice * 100.0) / 100.0;

    }
}

