package org.solvd.com.dao.utils;

import org.solvd.com.dao.Exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<P, K> implements GenericDAO<P, K> {

    private static final int UPDATE_EXECUTED_SUCCESSFULLY = 1;

    protected abstract String getCreateQuery(P object) throws DAOException, SQLException;

    protected abstract String getUpdateQuery();

    protected abstract String getSelectByIdQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getAllQuery();

    protected abstract void setIdStatement(PreparedStatement preparedStatement, K id) throws DAOException;

    protected abstract void setObjectStatement(PreparedStatement preparedStatement, P object) throws DAOException;

    protected abstract P readObject(ResultSet resultSet) throws DAOException;

    protected abstract String getCountRowsQuery();

    @Override
    public boolean create(P object) throws DAOException, SQLException {
        String createQuery = getCreateQuery(object);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DAOException("Problem with creating the object!");
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return true;
    }

    @Override
    public P read(K id) throws DAOException {
        P object;
        String selectByIdQuery = getSelectByIdQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectByIdQuery)) {
            setIdStatement(statement, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                object = readObject(resultSet);
            } else {
                throw new DAOException("Couldn't find an object with such ID!");
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return object;
    }

    @Override
    public void update(P object) throws DAOException {
        String updateQuery = getUpdateQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DAOException("Problem with updating the object!");
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<P> getAll(P object) throws DAOException {
        String allQuery = getAllQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(allQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DAOException("Problem with updating the object!");
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return null;
    }


    @Override
    public void delete(P object) throws DAOException {
        String deleteQuery = getDeleteQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DAOException("Problem with deleting the object!");
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public int countEntities() throws DAOException {
        String countRowsQuery = getCountRowsQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(countRowsQuery)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new DAOException("Problem counting entities!");
            }
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }
}
