package org.solvd.com.dao.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Date;

public class JsonMain {
    public static void main(String[] args) {

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

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(buyers);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            BuyersList deserializedBuyers = objectMapper.readValue(json, BuyersList.class);
            System.out.println("Deserialized Buyers :");
            deserializedBuyers.getBuyersList().forEach(t -> System.out.println(t));
        } catch (Exception e) {
            e.printStackTrace();
        }


        CartList cartList = new CartList();
        cartList.setCartId(3);
        cartList.setQuantity(10);
        cartList.setCreatedDate(new Date());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cartList);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            CartList deserializedCartList = objectMapper.readValue(json, CartList.class);
            System.out.println("Deserialized CartList : " + deserializedCartList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Category category = new Category();
        category.setCategoryId(5);
        category.setCategoryName("Dinner Sets");
        category.setDescription("kitchen items");
        category.setCreatedDate(new Date());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Category deserializedCategory = objectMapper.readValue(json, Category.class);
            System.out.println("Deserialized Category:" + deserializedCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(discountsList);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            DiscountsList deserializedDiscountsList = objectMapper.readValue(json, DiscountsList.class);
            System.out.println("Deserialized discounts list: ");
            deserializedDiscountsList.getDiscountsList().forEach(t -> System.out.println(t));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Products products = new Products();
        products.setProductId(4);
        products.setProductName("Laptop");
        products.setPrice(20.90);
        products.setDescription("Electronic laptop");
        products.setRating(4);
        products.setReviewCount(200);
        products.setQuantityAvailable(20);
        products.setCreatedDate(new Date());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Products deserializedProducts = objectMapper.readValue(json, Products.class);
            System.out.println("Deserialized Products :" + deserializedProducts);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}