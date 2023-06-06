package org.solvd.com.dao.utils;

import org.solvd.com.dao.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<P, K> {

    boolean create(P object) throws DaoException, SQLException;

    P read(K id) throws DaoException;

    void update(P object) throws DaoException;

    List<P> getAll(P object) throws DaoException;

    void delete(P object) throws DaoException;
}

