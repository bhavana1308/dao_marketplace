package org.solvd.com.dao.patterns.factory;

public class Main {
    public static void main(String[] args) {

        BuyerFactory simpleBuyerFactory = new SimpleBuyerFactory();
        Buyer simpleBuyer = simpleBuyerFactory.createBuyer();
        simpleBuyer.displayInfo();


        BuyerFactory premiumBuyerFactory = new PremiumBuyerFactory();
        Buyer premiumBuyer = premiumBuyerFactory.createBuyer();
        premiumBuyer.displayInfo();

    }
}
