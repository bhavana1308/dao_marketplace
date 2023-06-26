package org.solvd.com.dao.patterns.strategy;

public class Main {

    public static void main(String[] args) {

        Product product1 = new Product("laptop", 999.9, new NoDiscountStrategy());
        System.out.println("Product name :" + product1.getName());
        System.out.println("Original Price :" + product1.getPrice());
        System.out.println("Discounted Price :" + product1.applyDiscount());

        Product product2 = new Product("Phone", 99.9, new PercentageDiscountStrategy(0.20));
        System.out.println("Product name :" + product2.getName());
        System.out.println("Original Price :" + product2.getPrice());
        System.out.println("Discounted Price :" + product2.applyDiscount());


    }
}