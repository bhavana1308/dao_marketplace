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

        Product product = new Product();
        product.setProductId(4);
        product.setProductName("Laptop");
        product.setPrice(20.90);
        product.setDescription("Electronic laptop");
        product.setRating(4);
        product.setReviewCount(200);
        product.setQuantityAvailable(20);
        product.setCreatedDate(new Date());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);
            System.out.println(json);
            objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Product deserializedProducts = objectMapper.readValue(json, Product.class);
            System.out.println("Deserialized Products :" + deserializedProducts);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}