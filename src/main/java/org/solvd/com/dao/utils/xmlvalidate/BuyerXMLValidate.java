package org.solvd.com.dao.utils.xmlvalidate;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BuyerXMLValidate {

    public static void main(String[] args) {

        String xmlFilePath = "src/test/buyer.xml";

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

            String fName = document.getElementsByTagName("fName").item(0).getTextContent();
            System.out.println("Buyer first name : " + fName);
            String lName = document.getElementsByTagName("lName").item(0).getTextContent();
            System.out.println("Buyer last name : " + lName);
            String email = document.getElementsByTagName("email").item(0).getTextContent();
            System.out.println("Buyer email : " + email);
            String password = document.getElementsByTagName("password").item(0).getTextContent();
            System.out.println("Buyer password : " + password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
