package org.solvd.com.dao.model;

public class Discounts {

    private int discountId;
    private String discountName;
    private String description;
    private int discountPercent;

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

    @Override
    public String toString() {
        return "Discounts{" +
                "discountId=" + discountId +
                ", discountName='" + discountName + '\'' +
                ", description='" + description + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
