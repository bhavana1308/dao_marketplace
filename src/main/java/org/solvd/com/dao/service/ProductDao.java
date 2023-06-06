package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Products;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao<Products, Integer> {

    @Override
    protected String getCreateQuery(Products products) {
        return "INSERT INTO products (productName,price,rating,reviewCount,description,quantityAvailable) VALUES (?,?,?,?,?,?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM products WHERE productId = ?;";
    }

    protected String getSelectByNameQuery() {
        return "SELECT * FROM products WHERE productName = ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE products SET productName = ? WHERE productId = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM products WHERE productId = ?";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM products";
    }

    @Override
    protected String getCountRowsQuery() {
        return "SELECT count(*) FROM products;";
    }

    @Override
    protected void setIdStatement(PreparedStatement statement, Integer productId) throws DaoException {
        try {
            statement.setInt(1, productId);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    protected void setObjectStatement(PreparedStatement statement, Products products) throws DaoException {
        try {
            if (products.getProductId() != 0) {
                statement.setString(1, products.getProductName());
                statement.setDouble(2, products.getPrice());
                statement.setInt(3, products.getRating());
                statement.setInt(4, products.getReviewCount());
                statement.setString(5, products.getDescription());
                statement.setInt(6, products.getQuantityAvailable());

            } else {
                statement.setString(1, products.getProductName());
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    protected Products readObject(ResultSet resultSet) throws DaoException {
        Products products = new Products();
        try {
            products.setProductId(resultSet.getInt("productId"));
            products.setProductName(resultSet.getString("productName"));
            products.setPrice(resultSet.getDouble("price"));
            products.setRating(resultSet.getInt("rating"));
            products.setReviewCount(resultSet.getInt("reviewCount"));
            products.setDescription(resultSet.getString("description"));
            products.setQuantityAvailable(resultSet.getInt("quantityAvailable"));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return products;
    }

    public Products findByName(String productName) throws DaoException {
        Products products;
        String selectByNameQuery = getSelectByNameQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectByNameQuery)) {
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                products = readObject(resultSet);
            } else {
                throw new DaoException("Couldn't find a product with such ID!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return products;
    }

    public List<Products> getAll() throws DaoException {
        List<Products> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = getAllQuery();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                double price = resultSet.getDouble("price");
                int rating = resultSet.getInt("rating");
                int reviewCount = resultSet.getInt("reviewCount");
                String description = resultSet.getString("description");
                int quantityAvailable = resultSet.getInt("quantityAvailable");
                Products products1 = new Products(productId, productName, price, rating, reviewCount, description, quantityAvailable);
                products.add(products1);
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return products;
    }

    public Products deleteQuery(Products products) throws DaoException {
        String deleteQuery = getDeleteQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, products.getProductId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return products;
    }
}