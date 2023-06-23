package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Product;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao<Product> {

    private final String SELECT_BY_PRODUCT_NAME = "SELECT * FROM product WHERE productName = ?;";

    private final String GET_ALL_QUERY = "SELECT * FROM product";


    private Product getProductsFromResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("productId"));
        product.setProductName(resultSet.getString("productName"));
        product.setPrice(resultSet.getDouble("price"));
        product.setRating(resultSet.getInt("rating"));
        product.setReviewCount(resultSet.getInt("reviewCount"));
        product.setDescription(resultSet.getString("description"));
        product.setQuantityAvailable(resultSet.getInt("quantityAvailable"));
        return product;
    }

    public Product findByName(String productName) {
        Product product = new Product();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_PRODUCT_NAME)) {
            statement.setString(1, productName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                product = getProductsFromResultSet(resultSet);
            } else {
                throw new DaoException("Couldn't find a product with such ID!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Product product1 = getProductsFromResultSet(resultSet);
                products.add(product1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product insert(Product entity) {
        return entity;
    }

    @Override
    public Product update(Product entity) {
        return entity;
    }

    @Override
    public void delete(Product entity) {

    }

}