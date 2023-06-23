package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Discount;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountDao extends AbstractDao<Discount> {

    private final String INSERT_QUERY = "INSERT INTO discount (discountName,description,discountPercent) VALUES (?,?,?);";

    private final String UPDATE_QUERY = "UPDATE discount SET discountName=?, description=?, discountPercent=? WHERE discountId = ?;";

    private final String GET_RANDOM_QUERY = "SELECT * FROM discount LIMIT 1;";

    private final String GET_ALL_QUERY = "SELECT * FROM discount";


    private Discount getDiscountFromResultSet(ResultSet resultSet) throws SQLException {
        Discount discount = new Discount();
        discount.setDiscountId(resultSet.getInt("discountId"));
        discount.setDiscountName(resultSet.getString("discountName"));
        discount.setDescription(resultSet.getString("description"));
        discount.setDiscountPercent(resultSet.getInt("discountPercent"));
        return discount;
    }

    public Discount getRandomDiscount() {
        Discount discount = null;
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_RANDOM_QUERY);
            if (resultSet.next()) {
                discount = getDiscountFromResultSet(resultSet);
            } else {
                throw new DaoException("No discount entry was found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discount;
    }

    public Discount insert(Discount discount) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, discount.getDiscountName());
            statement.setString(2, discount.getDescription());
            statement.setInt(3, discount.getDiscountPercent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    public Discount update(Discount discount) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, discount.getDiscountName());
            statement.setString(2, discount.getDescription());
            statement.setInt(3, discount.getDiscountPercent());
            statement.setInt(4, discount.getDiscountId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    @Override
    public void delete(Discount entity) {

    }

    @Override
    public Discount findById(int id) {
        return null;
    }

    public List<Discount> getAll() {
        List<Discount> discount = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Discount discount1 = getDiscountFromResultSet(resultSet);
                discount.add(discount1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }
}

