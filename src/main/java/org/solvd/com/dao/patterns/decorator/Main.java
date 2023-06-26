package org.solvd.com.dao.patterns.decorator;

public class Main {

    public static void main(String[] args) {

        Product basicProduct = new BasicProduct("laptop", 999.9);

        Product discountedProduct = new DiscountedProduct(basicProduct, 0.1);

        System.out.println("Basic Product:");
        System.out.println("Description :" + basicProduct.getDescription());
        System.out.println("Price:" + basicProduct.getPrice());

        System.out.println("Discounted Product:");
        System.out.println("Description :" + discountedProduct.getDescription());
        System.out.println("Price:" + discountedProduct.getPrice());
    }
}
