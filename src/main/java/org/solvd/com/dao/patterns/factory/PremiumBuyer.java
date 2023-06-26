package org.solvd.com.dao.patterns.factory;

public class PremiumBuyer extends Buyer {

    public PremiumBuyer() {
        this.buyerId = 3;
        this.email = "aaaa@gmail.com";
        this.fName = "venny";
        this.lName = "a";
        this.password = "welcome123";

    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Buyer");
        System.out.println("Buyer Id :" + buyerId);
        System.out.println("Buyer Email :" + email);
        System.out.println("Buyer first name :" + fName);
        System.out.println("Buyer last name :" + lName);
        System.out.println("Buyer password :" + password);
    }
}
