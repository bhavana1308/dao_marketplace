package org.solvd.com.dao.model;

import org.solvd.com.dao.Exception.DAOException;
import org.solvd.com.dao.service.*;
import org.solvd.com.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class Executor {

    static {

        System.out.println("-------------Information about online marketplace----------");
    }

    public static void main(String[] args) throws DAOException, SQLException {
        Connection con = ConnectionFactory.getConnection();

        if (con != null) {
            System.out.println("Database connection successful!");
        }
        System.out.println("-------------BUYER----------");
        BuyerDAO buyer = new BuyerDAO();
        System.out.println("Number of records in buyer table = " + buyer.countEntities());
        System.out.println("------------- LIST OF BUYERS----------");
        buyer.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- RANDOM BUYERS----------");
        System.out.println(buyer.getRandomBuyer());
        System.out.println("------------- INSERT BUYER----------");
        Buyer buyer1 = new Buyer(3, "test@gmail.com", "Mike", "Tully", "Welcome789$");
        System.out.println(buyer.insertQuery(buyer1));
        System.out.println("------------- UPDATE BUYER----------");
        Buyer buyer2 = new Buyer(2, "venny@gmail.com", "Venny", "A", "10101");
        System.out.println(buyer.updateQuery(buyer2));
        System.out.println("------------- DELETE BUYER----------");
        Buyer buyer3 = new Buyer(3);
        buyer.deleteQuery(buyer3);
        System.out.println("buyer id "+buyer3.getBuyerId()+" deleted ");
        System.out.println("------------- LIST OF BUYERS----------");
        buyer.getAll().forEach(t -> System.out.println(t));
        System.out.println("-------------PRODUCTS----------");
        ProductDAO products = new ProductDAO();
        System.out.println("-------------FIND BY PRODUCT NAME----------");
        System.out.println(products.findByName("Shirts"));
        System.out.println("------------- LIST OF PRODUCTS----------");
        products.getAll().forEach(t -> System.out.println(t));
        System.out.println("------------- DELETE PRODUCT----------");
        Products products1 = new Products(3);
        products.deleteQuery(products1);
        System.out.println("product id "+products1.getProductId()+" deleted");
        System.out.println("------------- LIST OF PRODUCTS----------");
        products.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------DISCOUNTS----------");
        DiscountsDAO discounts = new DiscountsDAO();
        System.out.println("Random discount = " + discounts.getRandomDiscount());
        System.out.println("------------- INSERT DISCOUNTS----------");
        Discounts discounts1 = new Discounts(3, "Christmas Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 20);
        System.out.println(discounts.insertQuery(discounts1));
        System.out.println("------------- UPDATE DISCOUNTS----------");
        Discounts discounts2 = new Discounts(2, "Independence Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 25);
        System.out.println(discounts.updateQuery(discounts2));
        System.out.println("------------- DELETE DISCOUNTS----------");
        Discounts discounts3 = new Discounts(3);
        discounts.deleteQuery(discounts3);
        System.out.println("Discount id "+discounts1.getDiscountId()+" deleted");
        System.out.println("------------- LIST OF DISCOUNTS---------");
        discounts.getAll().forEach(t -> System.out.println(t));

        System.out.println("-------------CART LIST----------");
        CartListDAO cartList = new CartListDAO();
        System.out.println("-------------FIND BY CART ID----------");
        System.out.println(cartList.findByCartId(1));

        System.out.println("-------------CATEGORY----------");
        CategoryDAO category = new CategoryDAO();
        System.out.println("------------- RANDOM CATEGORY----------");
        System.out.println("Random category = " + category.getRandomCategory());
        System.out.println("------------- INSERT CATEGORY----------");
        Category category1 = new Category(3, "Electronics", "Laptop");
        System.out.println(category.insertQuery(category1));
        System.out.println("------------- UPDATE CATEGORY----------");
        Category category2 = new Category(2, "Crockery", "Household Items");
        System.out.println(category.updateQuery(category2));
        System.out.println("------------- LIST OF CATEGORY----------");
        category.getAll().forEach(t -> System.out.println(t));

    }

}

