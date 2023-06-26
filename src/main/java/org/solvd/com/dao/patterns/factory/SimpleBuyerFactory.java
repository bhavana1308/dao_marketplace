package org.solvd.com.dao.patterns.factory;

public class SimpleBuyerFactory implements BuyerFactory {
    @Override
    public Buyer createBuyer() {
        return new SimpleBuyer();
    }
}
