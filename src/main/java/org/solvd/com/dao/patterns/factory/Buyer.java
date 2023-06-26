package org.solvd.com.dao.patterns.factory;

public abstract class Buyer {

    protected int buyerId;
    protected String email;
    protected String fName;
    protected String lName;
    protected String password;

    public abstract void displayInfo();


}
