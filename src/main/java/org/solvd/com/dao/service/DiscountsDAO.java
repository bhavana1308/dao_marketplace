package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DAOException;
import org.solvd.com.dao.model.Discounts;
import org.solvd.com.dao.utils.AbstractDAO;
import org.solvd.com.dao.utils.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscountsDAO extends AbstractDAO<Discounts, Integer> {

    @Override
    protected String getCreateQuery(Discounts discounts) {
        return "INSERT INTO discounts (discountName,description,discountPercent) VALUES (?,?,?);";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE discounts SET discountName=?,description=?,discountPercent=? WHERE discountId = ?;";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM discounts WHERE discountId = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM discounts WHERE discountId= ?";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM discounts";
    }

    @Override
    protected String getCountRowsQuery() {
        return "SELECT count(*) FROM discounts;";
    }

    @Override
    protected void setIdStatement(PreparedStatement statement, Integer discountId) throws DAOException {
        try {
            statement.setInt(1, discountId);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    protected void setObjectStatement(PreparedStatement statement, Discounts discounts) throws DAOException {
        try {
            if (discounts.getDiscountId() != 0) {
                statement.setString(1, discounts.getDiscountName());
                statement.setString(2, discounts.getDescription());
                statement.setInt(3, discounts.getDiscountPercent());
            } else {
                statement.setString(1, discounts.getDiscountName());
                statement.setString(2, discounts.getDescription());
                statement.setInt(3, discounts.getDiscountPercent());
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    protected Discounts readObject(ResultSet resultSet) throws DAOException {
        Discounts discounts = new Discounts();
        try {
            discounts.setDiscountId(resultSet.getInt("discountId"));
            discounts.setDiscountName(resultSet.getString("discountName"));
            discounts.setDescription(resultSet.getString("description"));
            discounts.setDiscountPercent(resultSet.getInt("discountPercent"));
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }

    public Discounts getRandomDiscount() throws DAOException {
        Discounts discounts = new Discounts();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM discounts LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                discounts = readObject(resultSet);
            } else {
                throw new DAOException("No discounts entry was found!");
            }

        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }

    public Discounts insertQuery(Discounts discounts) throws DAOException {
        String createQuery = getCreateQuery(discounts);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, discounts.getDiscountName());
            statement.setString(2, discounts.getDescription());
            statement.setInt(3, discounts.getDiscountPercent());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }

    public Discounts updateQuery(Discounts discounts) throws DAOException {
        String updateQuery = getUpdateQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, discounts.getDiscountId());
            statement.setString(2, discounts.getDiscountName());
            statement.setString(3, discounts.getDescription());
            statement.setInt(4, discounts.getDiscountPercent());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }

    public List<Discounts> getAll() throws DAOException {
        List<Discounts> discounts = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = getAllQuery();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int discountId = resultSet.getInt("discountId");
                String discountName = resultSet.getString("discountName");
                String description = resultSet.getString("description");
                int discountPercent = resultSet.getInt("discountPercent");
                Discounts discounts1 = new Discounts(discountId, discountName, description, discountPercent);
                discounts.add(discounts1);
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }

    public Discounts deleteQuery(Discounts discounts) throws DAOException {
        String deleteQuery = getDeleteQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, discounts.getDiscountId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return discounts;
    }
}


