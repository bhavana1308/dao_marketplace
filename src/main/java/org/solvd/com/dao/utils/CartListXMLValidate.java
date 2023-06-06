package org.solvd.com.dao.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CartListXMLValidate {

    public static void main(String[] args) {

        String xmlFilePath = "src/test/cartList.xml";

        boolean isValid = validateXMLSchema(xmlFilePath);
        System.out.println("XML validation result : " + isValid);

        if (isValid) {
            parseXMLWithDOM(xmlFilePath);
        }
    }

    private static boolean validateXMLSchema (String xmlFilePath){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(null);
            builder.parse(xmlFilePath);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private static void parseXMLWithDOM (String xmlFilePath){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String cartId = document.getElementsByTagName("cartId").item(0).getTextContent();
            System.out.println("Cart Id: " + cartId);
            String buyerId = document.getElementsByTagName("buyerId").item(0).getTextContent();
            System.out.println("Buyer Id : " +buyerId);
            String productId = document.getElementsByTagName("productId").item(0).getTextContent();
            System.out.println("Product Id : " + productId);
            String quantity = document.getElementsByTagName("quantity").item(0).getTextContent();
            System.out.println("Quantity : " + quantity);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

