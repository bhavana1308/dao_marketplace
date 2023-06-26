package org.solvd.com.dao.patterns.builder;

public class Main {
    public static void main(String[] args) {

        Buyer buyer = new Buyer.BuyerBuilder()
                .setBuyerId(1)
                .setEmail("aaaaa@gmail.com")
                .setfName("john")
                .setlName("evers")
                .setPassword("123welcome")
                .build();

        System.out.println("Buyer Id :" + buyer.getBuyerId());
        System.out.println("Buyer Email :" + buyer.getEmail());
        System.out.println("Buyer first name :" + buyer.getFName());
        System.out.println("Buyer last name :" + buyer.getLName());
        System.out.println("Buyer password :" + buyer.getPassword());


    }
}
