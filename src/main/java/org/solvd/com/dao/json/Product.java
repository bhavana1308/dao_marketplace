package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonRootName(value = "Product")
public class Product {

    @JsonProperty("productId")
    private int productId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("price")
    private double price;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("reviewCount")
    private int reviewCount;

    @JsonProperty("description")
    private String description;

    @JsonProperty("quantityAvailable")
    private int quantityAvailable;

    @JsonProperty("createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;

    public Product(int productId, String productName, double price, int rating, int reviewCount, String description, int quantityAvailable) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.description = description;
        this.quantityAvailable = quantityAvailable;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public Product() {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "\n" + " productId=" + productId +
                " productName='" + productName + "\n" +
                " price=" + price + "\n" +
                " rating=" + rating + "\n" +
                " reviewCount=" + reviewCount + "\n" +
                " description='" + description + "\n" +
                " quantityAvailable=" + quantityAvailable + "\n" +
                " createdDate=" + createdDate + "\n" +
                '}';
    }
}




