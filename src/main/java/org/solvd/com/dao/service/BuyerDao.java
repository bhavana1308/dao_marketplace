package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDao extends AbstractDao<Buyer> {

    private final String INSERT_QUERY = "INSERT INTO buyer (email, fName, lName, password) VALUES (?,?,?,?);";

    private final String UPDATE_QUERY = "UPDATE buyer SET email=?, fName = ?, lName = ?, password=? WHERE buyerId = ?;";

    private final String GET_ALL_QUERY = "SELECT * FROM buyer";

    private Buyer getBuyerFromResultSet(ResultSet resultSet) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(resultSet.getInt("buyerId"));
        buyer.setEmail(resultSet.getString("email"));
        buyer.setFirstName(resultSet.getString("fName"));
        buyer.setLastName(resultSet.getString("lName"));
        buyer.setPassword(resultSet.getString("password"));
        return buyer;
    }

    @Override
    public Buyer findById(int id) {
        return null;
    }

    public Buyer insert(Buyer buyer) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, buyer.getEmail());
            statement.setString(2, buyer.getFirstName());
            statement.setString(3, buyer.getLastName());
            statement.setString(4, buyer.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyer;
    }

    public Buyer update(Buyer buyer) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, buyer.getEmail());
            statement.setString(2, buyer.getFirstName());
            statement.setString(3, buyer.getLastName());
            statement.setString(4, buyer.getPassword());
            statement.setInt(5, buyer.getBuyerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyer;
    }

    @Override
    public void delete(Buyer entity) {

    }

    public List<Buyer> getAll() {
        List<Buyer> buyers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Buyer buyer = getBuyerFromResultSet(resultSet);
                buyers.add(buyer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyers;
    }
}