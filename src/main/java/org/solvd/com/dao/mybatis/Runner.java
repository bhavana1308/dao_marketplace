package org.solvd.com.dao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.solvd.com.dao.model.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis_config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        System.out.println("-------------BUYER----------");
        BuyerMapper buyerMapper = session.getMapper(BuyerMapper.class);
        Buyer buyer1 = new Buyer(4, "aaa.test@gmail.com", "aaa", "Test", "Welcome123$");
        int insertedBuyer = buyerMapper.insertBuyer(buyer1);
        if (insertedBuyer == 1) {
            System.out.println("record inserted successfully");
        }

        Buyer buyer2 = new Buyer(3, "venny@gmail.com", "Venny", "A", "10101");
        int updatedBuyer = buyerMapper.updateBuyer(buyer2);
        if (updatedBuyer == 1) {
            System.out.println("record updated successfully");
        }

        session.selectOne("setForeignkey");
        int deletedBuyer = buyerMapper.deleteByBuyerId(2);
        if (deletedBuyer == 1) {
            System.out.println("record deleted successfully");
        }

        List<Buyer> list = buyerMapper.getAllFromBuyer();
        list.forEach(t -> System.out.println(t));

        System.out.println("-------------CART LIST----------");
        CartListMapper cartListMapper = session.getMapper(CartListMapper.class);
        int deletedCartList = cartListMapper.deleteByCartListId(2);
        if (deletedCartList == 1) {
            System.out.println("record deleted successfully");
        }

        CartList cartList = cartListMapper.getByCartListId(3);
        System.out.println(cartList);

        List<CartList> list1 = cartListMapper.getAllFromCartList();
        list1.forEach(t -> System.out.println(t));

        System.out.println("-------------CATEGORY----------");
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        Category category1 = new Category(4, "Electronics", "Laptop");
        int insertedCategory = categoryMapper.insertCategory(category1);
        if (insertedCategory == 1) {
            System.out.println("record inserted successfully");
        }

        Category category2 = new Category(3, "Crockery", "Household Items");
        int updatedCategory = categoryMapper.updateCategory(category2);
        if (updatedCategory == 1) {
            System.out.println("record updated successfully");
        }

        Category category = categoryMapper.getByCategoryId(3);
        System.out.println(category);

        List<Category> list2 = categoryMapper.getAllFromCategory();
        list2.forEach(t -> System.out.println(t));

        System.out.println("-------------DISCOUNTS----------");
        DiscountsMapper discountsMapper = session.getMapper(DiscountsMapper.class);
        Discounts discounts1 = new Discounts(4, "Christmas Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 20);
        int insertedDiscounts = discountsMapper.insertDiscounts(discounts1);
        if (insertedDiscounts == 1) {
            System.out.println("record inserted successfully");
        }
        Discounts discounts2 = new Discounts(3, "Independence Day Sale", "Additional Discount for Electronics, Hurry up and grab the deal", 25);
        int updatedDiscounts = discountsMapper.updateDiscounts(discounts2);
        if (updatedDiscounts == 1) {
            System.out.println("record updated successfully");
        }

        int deletedDiscounts = discountsMapper.deleteByDiscountsId(3);
        if (deletedDiscounts == 1) {
            System.out.println("record deleted successfully");
        }

        List<Discounts> list3 = discountsMapper.getAllFromDiscounts();
        list3.forEach(t -> System.out.println(t));

        System.out.println("-------------PRODUCTS----------");
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);
        int deletedProducts = productsMapper.deleteByProductId(3);
        if (deletedProducts == 1) {
            System.out.println("record deleted successfully");
        }

        List<Products> list4 = productsMapper.getAllFromProducts();
        list4.forEach(t -> System.out.println(t));

        Products products = productsMapper.getByProductName("Shirts");
        System.out.println(products);

        session.commit();
        session.close();


    }
}
