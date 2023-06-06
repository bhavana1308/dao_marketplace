package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DAOException;
import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.utils.AbstractDAO;
import org.solvd.com.dao.utils.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category, Integer> {

    @Override
    protected String getCreateQuery(Category category) {
        return "INSERT INTO category (categoryName,description) VALUES (?,?);";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE category SET categoryId=?,description=? WHERE categoryName= ?;";
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM category WHERE categoryId = ?;";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM category WHERE categoryId= ?";
    }

    @Override
    protected String getAllQuery() {
        return "SELECT * FROM category";
    }

    @Override
    protected String getCountRowsQuery() {
        return "SELECT count(*) FROM category;";
    }

    @Override
    protected void setIdStatement(PreparedStatement statement, Integer categoryId) throws DAOException {
        try {
            statement.setInt(1, categoryId);
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    protected void setObjectStatement(PreparedStatement statement, Category category) throws DAOException {
        try {
            if (category.getCategoryId() != 0) {
                statement.setString(1, category.getCategoryName());
                statement.setString(2, category.getDescription());
            } else {
                statement.setString(1, category.getCategoryName());
                statement.setString(2, category.getDescription());
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    protected Category readObject(ResultSet resultSet) throws DAOException {
        Category category = new Category();
        try {
            category.setCategoryId(resultSet.getInt("categoryId"));
            category.setCategoryName(resultSet.getString("categoryName"));
            category.setDescription(resultSet.getString("description"));
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return category;
    }


    public Category getRandomCategory() throws DAOException {
        Category category;
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM category LIMIT 1;";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                category = readObject(resultSet);
            } else {
                throw new DAOException("No category entry was found!");
            }

        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return category;
    }

    public Category insertQuery(Category category) throws DAOException {
        String createQuery = getCreateQuery(category);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return category;
    }

    public Category updateQuery(Category category) throws DAOException {
        String updateQuery = getUpdateQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setInt(1, category.getCategoryId());
            statement.setString(2, category.getCategoryName());
            statement.setString(3, category.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return category;
    }

    public List<Category> getAll() throws DAOException {
        List<Category> category = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            String query = getAllQuery();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("categoryId");
                String categoryName = resultSet.getString("categoryName");
                String description = resultSet.getString("description");
                Category category1 = new Category(categoryId, categoryName, description);
                category.add(category1);
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return category;
    }
}




