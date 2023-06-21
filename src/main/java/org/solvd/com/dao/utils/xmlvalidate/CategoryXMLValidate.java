package org.solvd.com.dao.utils.xmlvalidate;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class CategoryXMLValidate {

    public static void main(String[] args) {

        String xmlFilePath = "src/test/category.xml";

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

            String categoryId = document.getElementsByTagName("categoryId").item(0).getTextContent();
            System.out.println("Category Id: " + categoryId);
            String categoryName = document.getElementsByTagName("categoryName").item(0).getTextContent();
            System.out.println("Category Name: " + categoryName);
            String description = document.getElementsByTagName("description").item(0).getTextContent();
            System.out.println("Description : " + description);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
