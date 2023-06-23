package org.solvd.com.dao.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

    @XmlElement
    private int productId;

    @XmlElement
    private String productName;

    @XmlElement
    private double price;

    @XmlElement
    private int rating;

    @XmlElement
    private int reviewCount;

    @XmlElement
    private String description;

    @XmlElement
    private int quantityAvailable;

    @XmlElement
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
