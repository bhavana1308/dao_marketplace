package org.solvd.com.dao.service;

import org.solvd.com.dao.Exception.DAOException;
import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.AbstractDAO;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO extends AbstractDAO<Buyer, Integer> {

    @Override
    protected String getCreateQuery(Buyer buyer) {
        return "INSERT INTO buyer (email, fName, lName, password) VALUES (?,?,?,?);";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE buyer SET email=?, fName = ?, lName = ? ,password=? WHERE buyerId = ?;";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM buyer WHERE buyerId = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return " DELETE FROM buyer WHERE buyerId = ? ;";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM buyer";
    }

    @Override
    protected String getCountRowsQuery() {
        return "SELECT count(*) FROM buyer;";
    }

    @Override
    protected void setIdStatement(PreparedStatement statement, Integer buyerId) throws DAOException {
        try {
            statement.setInt(1, buyerId);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    protected void setObjectStatement(PreparedStatement statement, Buyer buyer) throws DAOException {
        try {
            if (buyer.getBuyerId() != 0) {
                statement.setString(1, buyer.getEmail());
                statement.setString(2, buyer.getFirstName());
                statement.setString(3, buyer.getLastName());
                statement.setString(4, buyer.getPassword());
            } else {
                statement.setString(1, buyer.getEmail());
                statement.setString(2, buyer.getFirstName());
                statement.setString(3, buyer.getLastName());
                statement.setString(4, buyer.getPassword());
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    protected Buyer readObject(ResultSet resultSet) throws DAOException {
        Buyer buyer = new Buyer();
        try {
            buyer.setBuyerId(resultSet.getInt("buyerId"));
            buyer.setEmail(resultSet.getString("email"));
            buyer.setFirstName(resultSet.getString("fName"));
            buyer.setLastName(resultSet.getString("lName"));
            buyer.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;
    }


    public Buyer getRandomBuyer() throws DAOException {
        Buyer buyer = new Buyer();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM buyer LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                buyer = readObject(resultSet);
            } else {
                throw new DAOException("No buyer entry was found!");
            }

        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;
    }

    public List<Buyer> getAll() throws DAOException {
        List<Buyer> buyer = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = getAllQuery();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int buyerId = resultSet.getInt("buyerId");
                String email = resultSet.getString("email");
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");
                String password = resultSet.getString("password");
                Buyer buyer1 = new Buyer(buyerId, email, fName, lName, password);
                buyer.add(buyer1);
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;

    }


    public Buyer insertQuery(Buyer buyer) throws DAOException {
        String createQuery = getCreateQuery(buyer);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, buyer.getEmail());
            statement.setString(2, buyer.getFirstName());
            statement.setString(3, buyer.getLastName());
            statement.setString(4, buyer.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;
    }

    public Buyer updateQuery(Buyer buyer) throws DAOException {
        String updateQuery = getUpdateQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.setString(2, buyer.getEmail());
            statement.setString(3, buyer.getFirstName());
            statement.setString(4, buyer.getLastName());
            statement.setString(5, buyer.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;
    }

    public Buyer deleteQuery(Buyer buyer) throws DAOException {
        String deleteQuery = getDeleteQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, buyer.getBuyerId());
            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS=1");
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return buyer;
    }

}
