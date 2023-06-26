package org.solvd.com.dao.patterns.facade;

public class ProductFacade {

    private final Product product;

    public ProductFacade(int productId, String productName, double price) {
        this.product = new Product(productId, productName, price);
    }

    public String getProductDetails() {

        String details = "Product Details :\n";
        details += "Product Id : " + product.getProductId() + "\n";
        details += "Product Name : " + product.getProductName() + "\n";
        details += "Product Price : " + product.getPrice() + "\n";
        return details;

    }
}
