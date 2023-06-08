package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Products;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao<Products> {

    private final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM products WHERE productName = ?;";

    private final String DELETE_QUERY = "DELETE FROM products WHERE productId = ?";

    private final String GET_ALL_QUERY = "SELECT * FROM products";


    private Products getProductsFromResultSet(ResultSet resultSet) throws SQLException {
        Products products = new Products();
        products.setProductId(resultSet.getInt("productId"));
        products.setProductName(resultSet.getString("productName"));
        products.setPrice(resultSet.getDouble("price"));
        products.setRating(resultSet.getInt("rating"));
        products.setReviewCount(resultSet.getInt("reviewCount"));
        products.setDescription(resultSet.getString("description"));
        products.setQuantityAvailable(resultSet.getInt("quantityAvailable"));
        return products;
    }

    public Products findByName(String productName) {
        Products products = new Products();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_PRODUCT_NAME)) {
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                products = getProductsFromResultSet(resultSet);
            } else {
                throw new DaoException("Couldn't find a product with such ID!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Products findById(int id) {
        return null;
    }

    public List<Products> getAll() {
        List<Products> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Products products1 = getProductsFromResultSet(resultSet);
                products.add(products1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insert(Products entity) {

    }

    @Override
    public Products update(Products entity) {
        return entity;
    }

    public void delete(Products products) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, products.getProductId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (Exception e) {

        }

    }
}