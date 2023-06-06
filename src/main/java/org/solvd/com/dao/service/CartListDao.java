package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartListDao extends AbstractDao<CartList, Integer> {

    @Override
    protected String getCreateQuery(CartList cartList) {
        return "INSERT INTO CartList (cartId, buyerId, productId, quantity) VALUES (?,?,?,?);";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM CartList WHERE cartId= ?;";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE CartList SET buyerId = ?, productId = ? WHERE cartId= ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM CartList WHERE cartId= ?;";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM CartList;";
    }

    @Override
    protected String getCountRowsQuery() {
        return "SELECT count(*) FROM CartList;";
    }

    @Override
    protected void setIdStatement(PreparedStatement statement, Integer cartId) throws DaoException {
        try {
            statement.setInt(1, cartId);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    protected void setObjectStatement(PreparedStatement statement, CartList cartList) throws DaoException {
        try {
            if (cartList.getCartId() != 0) {
                statement.setInt(1, cartList.getCartId());
                statement.setInt(2, cartList.getBuyerId());
                statement.setInt(3, cartList.getProductId());
                statement.setInt(4, cartList.getQuantity());
            } else {
                statement.setInt(1, cartList.getCartId());
                statement.setInt(2, cartList.getBuyerId());
                statement.setInt(3, cartList.getProductId());
                statement.setInt(4, cartList.getQuantity());
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    protected CartList readObject(ResultSet resultSet) throws DaoException {
        CartList cartList = new CartList();
        try {
            cartList.setCartId(resultSet.getInt("cartId"));
            cartList.setBuyerId(resultSet.getInt("buyerId"));
            cartList.setProductId(resultSet.getInt("productId"));
            cartList.setQuantity(resultSet.getInt("quantity"));
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return cartList;
    }

    public CartList read(int buyerId, int productId) throws DaoException {
        String query = "SELECT * FROM CartList WHERE buyerId = " + buyerId +
                " AND productId = " + productId;
        CartList cartList = new CartList();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                cartList = readObject(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return cartList;
    }

    public List<CartList> findByCartId(Integer cartId) throws DaoException {
        List<CartList> cartList = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM CartList WHERE cartId = " + cartId + ";";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int buyerId = resultSet.getInt("buyerId");
                int productId = resultSet.getInt("productId");
                int quantity = resultSet.getInt("quantity");
                cartList.add(new CartList(cartId, buyerId, productId, quantity));
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return cartList;
    }
}
