package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.utils.AbstractDao;
import org.solvd.com.dao.utils.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends AbstractDao<Category> {


    private final String INSERT_QUERY = "INSERT INTO category (categoryName,description) VALUES (?,?);";

    private final String UPDATE_QUERY = "UPDATE category SET categoryName=?,description=? WHERE categoryId= ?;";

    private final String GET_ALL_QUERY = "SELECT * FROM category";

    private final String GET_RANDOM_QUERY = "SELECT * FROM category LIMIT 1;";


    public Category getRandomCategory() {
        Category category = null;
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_RANDOM_QUERY);
            if (resultSet.next()) {
                category = getCategoryFromResultSet(resultSet);
            } else {
                throw new DaoException("No category entry was found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    public Category insert(Category category) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public Category update(Category category) {
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, category.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return category;
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()) {
                Category category1 = getCategoryFromResultSet(resultSet);
                categories.add(category1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return categories;
    }

    @Override
    public void delete(Category entity) {

    }

    private Category getCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setCategoryId(resultSet.getInt("categoryId"));
        category.setCategoryName(resultSet.getString("categoryName"));
        category.setDescription(resultSet.getString("description"));
        return category;
    }

}




