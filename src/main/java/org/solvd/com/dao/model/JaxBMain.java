package org.solvd.com.dao.model;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class JaxBMain {
    public static void main(String[] args) {

        //Buyers  marshaller included list and date.
        try {
            BuyersList buyers = new BuyersList();
            buyers.setBuyersList(new ArrayList<Buyer>());
            Buyer buyer1 = new Buyer();
            buyer1.setBuyerId(4);
            buyer1.setEmail("apple@yahoo.com");
            buyer1.setFirstName("Gracie");
            buyer1.setLastName("Hailine");
            buyer1.setPassword("123456");
            buyer1.setCreatedDate(new Date());

            Buyer buyer2 = new Buyer();
            buyer2.setBuyerId(5);
            buyer2.setEmail("Myka@yahoo.com");
            buyer2.setFirstName("Myka");
            buyer2.setLastName("Nyroo");
            buyer2.setPassword("123789");
            buyer2.setCreatedDate(new Date());

            buyers.getBuyersList().add(buyer1);
            buyers.getBuyersList().add(buyer2);

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/buyersList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(BuyersList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(buyers, file);
            jaxbMarshaller.marshal(buyers, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        // Buyer unmarshaller with list and date
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/buyersList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(BuyersList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BuyersList buyers = (BuyersList) jaxbUnmarshaller.unmarshal(file);
            for (Buyer buyer : buyers.getBuyersList()) {
                System.out.println("Buyer id " + buyer.getBuyerId());
                System.out.println("Buyer first name : " + buyer.getFirstName());
                System.out.println("Buyer last name : " + buyer.getLastName());
                System.out.println("Buyer email : " + buyer.getEmail());
                System.out.println("Buyer password : " + buyer.getPassword());
                System.out.println("Created date : " + buyer.getCreatedDate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //cart list marshaller
        try {
            CartList cartList = new CartList();
            cartList.setCartId(3);
            cartList.setQuantity(10);
            cartList.setCreatedDate(new Date());

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/cartList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CartList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(cartList, file);
            jaxbMarshaller.marshal(cartList, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        //cart list unmarshaller
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/cartList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(CartList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            CartList cartList = (CartList) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Cart id : " + cartList.getCartId());
            System.out.println("Quantity : " + cartList.getQuantity());
            System.out.println("Created date : " + cartList.getCreatedDate());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //category marshaller
        try {
            Category category = new Category();
            category.setCategoryId(5);
            category.setCategoryName("Dinner Sets");
            category.setDescription("kitchen items");
            category.setCreatedDate(new Date());

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/category.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(category, file);
            jaxbMarshaller.marshal(category, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        //category unmarshaller
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/category.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Category category = (Category) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Category id : " + category.getCategoryId());
            System.out.println("Category Name : " + category.getCategoryName());
            System.out.println("Category Description : " + category.getDescription());
            System.out.println("Created date : " + category.getCreatedDate());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //Discounts marshaller with list and date
        try {
            DiscountsList discountsList = new DiscountsList();
            discountsList.setDiscountsList(new ArrayList<Discounts>());
            Discounts discounts1 = new Discounts();
            discounts1.setDiscountId(4);
            discounts1.setDiscountName("Labour day sale");
            discounts1.setDescription("50 percent off on everything");
            discounts1.setDiscountPercent(50);
            discounts1.setCreatedDate(new Date());

            Discounts discounts2 = new Discounts();
            discounts2.setDiscountId(5);
            discounts2.setDiscountName("memorial day sale");
            discounts2.setDescription("60 percent off on crockery");
            discounts2.setDiscountPercent(60);
            discounts2.setCreatedDate(new Date());

            discountsList.getDiscountsList().add(discounts1);
            discountsList.getDiscountsList().add(discounts2);

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/discountsList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DiscountsList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(discountsList, file);
            jaxbMarshaller.marshal(discountsList, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        //Discounts unmarshaller with list and date
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/discountsList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DiscountsList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DiscountsList discountsList = (DiscountsList) jaxbUnmarshaller.unmarshal(file);
            for (Discounts discounts : discountsList.getDiscountsList()) {
                System.out.println("Discount id : " + discounts.getDiscountId());
                System.out.println("Discount Name : " + discounts.getDiscountName());
                System.out.println("Discount Description : " + discounts.getDescription());
                System.out.println("Discount percent : " + discounts.getDiscountPercent());
                System.out.println("Created date : " + discounts.getCreatedDate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //products marshaller
        try {
            Products products = new Products();
            products.setProductId(4);
            products.setProductName("Laptop");
            products.setPrice(20.90);
            products.setDescription("Electronic laptop");
            products.setRating(4);
            products.setReviewCount(200);
            products.setQuantityAvailable(20);
            products.setCreatedDate(new Date());

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(products, file);
            jaxbMarshaller.marshal(products, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        //products unmarshaller
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Products products = (Products) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Product id : " + products.getProductId());
            System.out.println("product name : " + products.getProductName());
            System.out.println("product Description : " + products.getDescription());
            System.out.println("product price : " + products.getPrice());
            System.out.println("product rating : " + products.getRating());
            System.out.println("product reviewCount : " + products.getReviewCount());
            System.out.println("Quantity available : " + products.getQuantityAvailable());
            System.out.println("Created date : " + products.getCreatedDate());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
