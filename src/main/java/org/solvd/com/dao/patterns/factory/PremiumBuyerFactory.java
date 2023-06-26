package org.solvd.com.dao.patterns.factory;

public class PremiumBuyerFactory implements BuyerFactory {
    @Override
    public Buyer createBuyer() {
        return new PremiumBuyer();
    }
}
