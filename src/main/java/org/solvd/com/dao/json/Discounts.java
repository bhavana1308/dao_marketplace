package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonRootName(value = "Discounts")
public class Discounts {

    @JsonProperty("discountId")
    private int discountId;

    @JsonProperty("discountName")
    private String discountName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("discountPercent")
    private int discountPercent;

    @JsonProperty("createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;

    public Discounts(int discountId, String discountName, String description, int discountPercent) {
        this.discountId = discountId;
        this.discountName = discountName;
        this.description = description;
        this.discountPercent = discountPercent;
    }

    public Discounts(int discountId) {
        this.discountId = discountId;
    }

    public Discounts() {
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "\n" + " discountId=" + discountId + "\n" +
                " discountName='" + discountName + "\n" +
                " description='" + description + "\n" +
                " discountPercent=" + discountPercent + "\n" +
                " createdDate=" + createdDate + "\n" +
                '}';
    }
}
