package org.solvd.com.dao.patterns.factory;

public class SimpleBuyer extends Buyer {


    public SimpleBuyer() {
        this.buyerId = 2;
        this.email = "bbbbb@gmail.com";
        this.fName = "Chenny";
        this.lName = "b";
        this.password = "welcome456";

    }

    @Override
    public void displayInfo() {
        System.out.println("Simple Buyer");
        System.out.println("Buyer Id :" + buyerId);
        System.out.println("Buyer Email :" + email);
        System.out.println("Buyer first name :" + fName);
        System.out.println("Buyer last name :" + lName);
        System.out.println("Buyer password :" + password);
    }
}