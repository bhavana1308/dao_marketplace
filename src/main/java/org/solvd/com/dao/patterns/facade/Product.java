package org.solvd.com.dao.patterns.facade;

public class Product {

    private final int productId;
    private final String productName;
    private final double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;

    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }


}
