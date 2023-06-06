package org.solvd.com.dao.utils;

import org.solvd.com.dao.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao<P, K> implements GenericDao<P, K> {

    private static final int UPDATE_EXECUTED_SUCCESSFULLY = 1;

    protected abstract String getCreateQuery(P object) throws DaoException, SQLException;

    protected abstract String getUpdateQuery();

    protected abstract String getSelectByIdQuery();

    protected abstract String getDeleteQuery();

    protected abstract String getAllQuery();

    protected abstract void setIdStatement(PreparedStatement preparedStatement, K id) throws DaoException;

    protected abstract void setObjectStatement(PreparedStatement preparedStatement, P object) throws DaoException;

    protected abstract P readObject(ResultSet resultSet) throws DaoException;

    protected abstract String getCountRowsQuery();

    @Override
    public boolean create(P object) throws DaoException, SQLException {
        String createQuery = getCreateQuery(object);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(createQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DaoException("Problem with creating the object!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return true;
    }

    @Override
    public P read(K id) throws DaoException {
        P object;
        String selectByIdQuery = getSelectByIdQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectByIdQuery)) {
            setIdStatement(statement, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                object = readObject(resultSet);
            } else {
                throw new DaoException("Couldn't find an object with such ID!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return object;
    }

    @Override
    public void update(P object) throws DaoException {
        String updateQuery = getUpdateQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DaoException("Problem with updating the object!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public List<P> getAll(P object) throws DaoException {
        String allQuery = getAllQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(allQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DaoException("Problem with updating the object!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
        return null;
    }


    @Override
    public void delete(P object) throws DaoException {
        String deleteQuery = getDeleteQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            setObjectStatement(statement, object);
            if (statement.executeUpdate() < UPDATE_EXECUTED_SUCCESSFULLY) {
                throw new DaoException("Problem with deleting the object!");
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    public int countEntities() throws DaoException {
        String countRowsQuery = getCountRowsQuery();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(countRowsQuery)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                throw new DaoException("Problem counting entities!");
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }
}
