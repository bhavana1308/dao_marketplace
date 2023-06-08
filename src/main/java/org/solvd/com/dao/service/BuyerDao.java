package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDao extends AbstractDao<Buyer> {

    private final String INSERT_QUERY = "INSERT INTO buyer (email, fName, lName, password) VALUES (?,?,?,?);";

    private final String UPDATE_QUERY = "UPDATE buyer SET email=?, fName = ?, lName = ? ,password=? WHERE buyerId = ?;";

    private final String DELETE_QUERY = " DELETE FROM buyer WHERE buyerId = ? ;";

    private final String GET_ALL_QUERY = "SELECT * FROM buyer";


    @Override
    public Buyer findById(int id) {
        return null;
    }

    public List<Buyer> getAll() {
        List<Buyer> buyers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Buyer buyer1 = getBuyerFromResultSet(resultSet);
                buyers.add(buyer1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buyers;

    }

    public void insert(Buyer buyer) {
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
    }

    public void update(Buyer buyer) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.setString(2, buyer.getEmail());
            statement.setString(3, buyer.getFirstName());
            statement.setString(4, buyer.getLastName());
            statement.setString(5, buyer.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Buyer buyer) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Buyer getBuyerFromResultSet(ResultSet resultSet) throws SQLException {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(resultSet.getInt("buyerId"));
        buyer.setEmail(resultSet.getString("email"));
        buyer.setFirstName(resultSet.getString("fName"));
        buyer.setLastName(resultSet.getString("lName"));
        buyer.setPassword(resultSet.getString("password"));
        return buyer;
    }
}