package org.solvd.com.dao.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ProductsXMLValidate {

    public static void main(String[] args) {

        String xmlFilePath = "src/test/products.xml";

        boolean isValid = validateXMLSchema(xmlFilePath);
        System.out.println("XML validation result : " + isValid);

        if (isValid) {
            parseXMLWithDOM(xmlFilePath);
        }
    }

    private static boolean validateXMLSchema(String xmlFilePath) {
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

    private static void parseXMLWithDOM(String xmlFilePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFilePath);

            String productId = document.getElementsByTagName("productId").item(0).getTextContent();
            System.out.println("Product Id: " + productId);
            String productName = document.getElementsByTagName("productName").item(0).getTextContent();
            System.out.println("Product Name: " + productName);
            String price = document.getElementsByTagName("price").item(0).getTextContent();
            System.out.println("Price " + price);
            String rating = document.getElementsByTagName("rating").item(0).getTextContent();
            System.out.println("Product Rating: " + rating);
            String reviewCount = document.getElementsByTagName("reviewCount").item(0).getTextContent();
            System.out.println("Review Count: " + reviewCount);
            String description = document.getElementsByTagName("description").item(0).getTextContent();
            System.out.println("Description : " + description);
            String quantityAvailable = document.getElementsByTagName("quantityAvailable").item(0).getTextContent();
            System.out.println("Quantity Available: " + quantityAvailable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

