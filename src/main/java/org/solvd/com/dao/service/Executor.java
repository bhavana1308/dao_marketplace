package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.model.Discount;
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
        System.out.println("------------- LIST OF BUYERS----------");
        buyer.getAll().forEach(t -> System.out.println(t));
        System.out.println("-------------INSERT BUYER----------");
        Buyer buyer1 = new Buyer(4, "aaa.test@gmail.com", "aaa", "Test", "Welcome123$");
        System.out.println(buyer.insert(buyer1));
        System.out.println("------------- UPDATE BUYER----------");
        Buyer buyer2 = new Buyer(3, "venny@gmail.com", "Venny", "A", "10101");
        System.out.println(buyer.update(buyer2));
        System.out.println("------------- LIST OF BUYERS----------");
        buyer.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------PRODUCTS----------");
        ProductDao product = new ProductDao();
        System.out.println("-------------FIND BY PRODUCT NAME----------");
        System.out.println(product.findByName("Shirts"));
        System.out.println("------------- LIST OF PRODUCTS----------");
        product.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- LIST OF PRODUCTS----------");
        product.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------DISCOUNTS----------");
        DiscountDao discount = new DiscountDao();
        System.out.println("Random discount = " + discount.getRandomDiscount());
        System.out.println("------------- INSERT DISCOUNTS---------");
        Discount discounts1 = new Discount(4, "Christmas Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 20);
        System.out.println(discount.insert(discounts1));
        System.out.println("------------- UPDATE DISCOUNTS---------");
        Discount discounts2 = new Discount(2, "Independence Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 25);
        System.out.println(discount.update(discounts2));
        System.out.println("------------- LIST OF DISCOUNTS---------");
        discount.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------CART LIST----------");
        System.out.println("-------------FIND BY CART ID----------");
        CartListDao cartList = new CartListDao();
        System.out.println(cartList.findById(1));
        System.out.println("-------------DELETE CART LIST----------");
        CartList cartList1 = new CartList(2);
        cartList.delete(cartList1);
        System.out.println("cart id " + cartList1.getCartId() + " deleted ");

        System.out.println("-------------CATEGORY----------");
        CategoryDao category = new CategoryDao();
        System.out.println("------------- LIST OF CATEGORY----------");
        category.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- RANDOM CATEGORY----------");
        System.out.println("Random category = " + category.getRandomCategory());
        Category category1 = new Category(4, "Electronics", "Laptop");
        category.insert(category1);
        System.out.println("------------- UPDATE CATEGORY----------");
        Category category2 = new Category(3, "Crockery", "Household Items");
        System.out.println(category.update(category2));
        System.out.println("------------- LIST OF CATEGORY----------");
        category.getAll().forEach(t -> System.out.println(t));

    }
}



