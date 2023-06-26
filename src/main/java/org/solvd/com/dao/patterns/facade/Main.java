package org.solvd.com.dao.patterns.facade;

public class Main {
    public static void main(String[] args) {

        ProductFacade productFacade = new ProductFacade(3, "laptop", 999.99);
        String productDetails = productFacade.getProductDetails();
        System.out.println(productDetails);
    }
}
