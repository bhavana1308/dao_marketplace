package org.solvd.com.dao.model;

import org.solvd.com.dao.service.*;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Executor {

    static {

        System.out.println("-------------Information about online marketplace----------");
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionFactory.getConnection();

        if (con != null) {
            System.out.println("Database connection successful!");
        }
        System.out.println("-------------BUYER----------");
        BuyerDao buyer = new BuyerDao();
        Buyer buyer1 = new Buyer(4, "aaa.test@gmail.com", "aaa", "Test", "Welcome123$");
        buyer.insert(buyer1);
        System.out.println("------------- LIST OF BUYERS----------");
        buyer.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- UPDATE BUYER----------");
        Buyer buyer2 = new Buyer(2, "venny@gmail.com", "Venny", "A", "10101");
        System.out.println(buyer.update(buyer2));
        System.out.println("------------- DELETE BUYER----------");
        Buyer buyer3 = new Buyer(4);
        buyer.delete(buyer3);
        System.out.println("buyer id " + buyer3.getBuyerId() + " deleted ");

        System.out.println("-------------PRODUCTS----------");
        ProductDao products = new ProductDao();
        System.out.println("-------------FIND BY PRODUCT NAME----------");
        System.out.println(products.findByName("Shirts"));
        System.out.println("------------- LIST OF PRODUCTS----------");
        products.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- DELETE PRODUCT----------");
        Products products1 = new Products(3);
        products.delete(products1);
        System.out.println("product id " + products1.getProductId() + " deleted");
        System.out.println("------------- LIST OF PRODUCTS----------");
        products.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------DISCOUNTS----------");
        DiscountsDao discounts = new DiscountsDao();
        System.out.println("Random discount = " + discounts.getRandomDiscount());
        Discounts discounts1 = new Discounts(1, "Christmas Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 20);
        discounts.insert(discounts1);
        System.out.println("------------- LIST OF DISCOUNTS---------");
        discounts.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- UPDATE DISCOUNTS---------");
        Discounts discounts2 = new Discounts(1, "Independence Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 25);
        System.out.println(discounts.update(discounts2));
        System.out.println("------------- DELETE DISCOUNTS----------");
        Discounts discounts3 = new Discounts(3);
        discounts.delete(discounts3);
        System.out.println("Discount id " + discounts1.getDiscountId() + " deleted");

        System.out.println("-------------CART LIST----------");
        System.out.println("-------------FIND BY CART ID----------");
        CartListDao cartList = new CartListDao();
        System.out.println(cartList.findById(1));
        CartList cartList1 = new CartList(2);
        cartList.delete(cartList1);
        System.out.println("cart id " + cartList1.getCartId() + " deleted ");

        System.out.println("-------------CATEGORY----------");
        CategoryDao category = new CategoryDao();
        System.out.println("------------- RANDOM CATEGORY----------");
        System.out.println("Random category = " + category.getRandomCategory());
        Category category1 = new Category(4, "Electronics", "Laptop");
        category.insert(category1);
        System.out.println("------------- LIST OF CATEGORY----------");
        category.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- UPDATE CATEGORY----------");
        Category category2 = new Category(3, "Crockery", "Household Items");
        System.out.println(category.update(category2));
    }

}

