package org.solvd.com.dao.jaxb;


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

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/buyersList.xml");
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
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/buyersList.xml");
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

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/cartList.xml");
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
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/cartList.xml");
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

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/category.xml");
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
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/category.xml");
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
            discountsList.setDiscountsList(new ArrayList<Discount>());
            Discount discount1 = new Discount();
            discount1.setDiscountId(4);
            discount1.setDiscountName("Labour day sale");
            discount1.setDescription("50 percent off on everything");
            discount1.setDiscountPercent(50);
            discount1.setCreatedDate(new Date());

            Discount discount2 = new Discount();
            discount2.setDiscountId(5);
            discount2.setDiscountName("memorial day sale");
            discount2.setDescription("60 percent off on crockery");
            discount2.setDiscountPercent(60);
            discount2.setCreatedDate(new Date());

            discountsList.getDiscountsList().add(discount1);
            discountsList.getDiscountsList().add(discount2);

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/discountsList.xml");
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
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/discountsList.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(DiscountsList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DiscountsList discountsList = (DiscountsList) jaxbUnmarshaller.unmarshal(file);
            for (Discount discount : discountsList.getDiscountsList()) {
                System.out.println("Discount id : " + discount.getDiscountId());
                System.out.println("Discount Name : " + discount.getDiscountName());
                System.out.println("Discount Description : " + discount.getDescription());
                System.out.println("Discount percent : " + discount.getDiscountPercent());
                System.out.println("Created date : " + discount.getCreatedDate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        //products marshaller
        try {
            Product product = new Product();
            product.setProductId(4);
            product.setProductName("Laptop");
            product.setPrice(20.90);
            product.setDescription("Electronic laptop");
            product.setRating(4);
            product.setReviewCount(200);
            product.setQuantityAvailable(20);
            product.setCreatedDate(new Date());

            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(product, file);
            jaxbMarshaller.marshal(product, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();

        }

        //products unmarshaller
        try {
            File file = new File("/Users/bhavanareddy/IdeaProjects/onlinemarketplace/src/main/java/org/solvd/com/dao/utils/jaxbxml/products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Product product = (Product) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Product id : " + product.getProductId());
            System.out.println("product name : " + product.getProductName());
            System.out.println("product Description : " + product.getDescription());
            System.out.println("product price : " + product.getPrice());
            System.out.println("product rating : " + product.getRating());
            System.out.println("product reviewCount : " + product.getReviewCount());
            System.out.println("Quantity available : " + product.getQuantityAvailable());
            System.out.println("Created date : " + product.getCreatedDate());
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
