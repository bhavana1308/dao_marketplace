package org.solvd.com.dao.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        try (InputStream input = new FileInputStream("/src/main/resources/connection.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            final String CONNECTION_URL = properties.getProperty("CONNECTION_URL");
            final String USER = properties.getProperty("USER");
            final String PASS = properties.getProperty("PASS");

            return DriverManager.getConnection(CONNECTION_URL, USER, PASS);


        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file.");

        }
    }
}




