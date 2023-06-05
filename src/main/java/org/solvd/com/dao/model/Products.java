package org.solvd.com.dao.model;

public class Products {

    private int productId;
    private String productName;
    private double price;
    private int rating;
    private int reviewCount;
    private String description;
    private int quantityAvailable;

    public Products(int productId, String productName, double price, int rating, int reviewCount, String description, int quantityAvailable) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
    }

    public Products(int productId) {
        this.productId = productId;
    }

    public Products() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", reviewCount=" + reviewCount +
                ", description='" + description + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
