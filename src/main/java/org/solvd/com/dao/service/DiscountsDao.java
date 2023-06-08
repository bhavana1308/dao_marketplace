package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Discounts;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountsDao extends AbstractDao<Discounts> {

    private final String INSERT_QUERY = "INSERT INTO discounts (discountName,description,discountPercent) VALUES (?,?,?);";

    private final String UPDATE_QUERY = "UPDATE discounts SET discountName=?,description=?,discountPercent=? WHERE discountId = ?;";

    private final String GET_RANDOM_QUERY = "SELECT * FROM discounts LIMIT 1;";

    private final String DELETE_QUERY = "DELETE FROM discounts WHERE discountId= ?";

    private final String GET_ALL_QUERY = "SELECT * FROM discounts";


    private Discounts getDiscountsFromResultSet(ResultSet resultSet) throws SQLException {
        Discounts discounts = new Discounts();
        discounts.setDiscountId(resultSet.getInt("discountId"));
        discounts.setDiscountName(resultSet.getString("discountName"));
        discounts.setDescription(resultSet.getString("description"));
        discounts.setDiscountPercent(resultSet.getInt("discountPercent"));
        return discounts;
    }

    public Discounts getRandomDiscount() throws DaoException {
        Discounts discounts = null;
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_RANDOM_QUERY);
            if (resultSet.next()) {
                discounts = getDiscountsFromResultSet(resultSet);
            } else {
                throw new DaoException("No discounts entry was found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discounts;
    }

    public void insert(Discounts discounts) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, discounts.getDiscountName());
            statement.setString(2, discounts.getDescription());
            statement.setInt(3, discounts.getDiscountPercent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Discounts discounts) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, discounts.getDiscountId());
            statement.setString(2, discounts.getDiscountName());
            statement.setString(3, discounts.getDescription());
            statement.setInt(4, discounts.getDiscountPercent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Discounts findById(int id) {
        return null;
    }

    public List<Discounts> getAll() {
        List<Discounts> discounts = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Discounts discounts1 = getDiscountsFromResultSet(resultSet);
                discounts.add(discounts1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }

    public void delete(Discounts discounts) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, discounts.getDiscountId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


