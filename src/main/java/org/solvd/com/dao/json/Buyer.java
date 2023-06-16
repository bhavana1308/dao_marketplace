package org.solvd.com.dao.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonRootName(value = "Buyer")
public class Buyer {

    @JsonProperty("buyerId")
    private int buyerId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String fName;

    @JsonProperty("lastName")
    private String lName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("createdDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
        return "Buyer{" + "\n" +
                "buyerId=" + buyerId + "\n" +
                " email='" + email + '\'' + "\n" +
                " fName='" + fName + '\'' + "\n" +
                " lName='" + lName + '\'' + "\n" +
                " password='" + password + '\'' + "\n" +
                " createdDate=" + createdDate + "\n" +
                '}';
    }
}

