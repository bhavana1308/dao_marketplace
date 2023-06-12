package org.solvd.com.dao.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer {

    @XmlElement
    private int buyerId;

    @XmlElement
    private String email;

    @XmlElement
    private String fName;

    @XmlElement
    private String lName;

    @XmlElement
    private String password;

    @XmlElement
    private Date createdDate;


    public Buyer(int buyerId, String email, String fName, String lName, String password) {
        this.buyerId = buyerId;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
    }

    public Buyer(int buyerId) {
        this.buyerId = buyerId;
    }

    public Buyer() {

    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Override
    public String toString() {
        return "Buyer{" +
                "buyerId=" + buyerId +
                ", email='" + email + '\'' +
                ", firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
