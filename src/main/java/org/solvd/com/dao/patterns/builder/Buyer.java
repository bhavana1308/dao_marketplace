package org.solvd.com.dao.patterns.builder;

public class Buyer {

    private final int buyerId;
    private final String email;
    private final String fName;
    private final String lName;
    private final String password;


    public Buyer(BuyerBuilder builder) {
        this.buyerId = builder.buyerId;
        this.email = builder.email;
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.password = builder.password;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public String getEmail() {
        return email;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getPassword() {
        return password;
    }

    public static class BuyerBuilder {
        private int buyerId;
        private String email;
        private String fName;
        private String lName;
        private String password;

        public BuyerBuilder setBuyerId(int buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public BuyerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public BuyerBuilder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public BuyerBuilder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public BuyerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Buyer build() {
            return new Buyer(this);
        }
    }
}
