package org.solvd.com.dao.jaxb;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Discounts {

    @XmlElement
    private int discountId;

    @XmlElement
    private String discountName;

    @XmlElement
    private String description;

    @XmlElement
    private int discountPercent;

    @XmlElement
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
                "discountId=" + discountId +
                ", discountName='" + discountName + '\'' +
                ", description='" + description + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
