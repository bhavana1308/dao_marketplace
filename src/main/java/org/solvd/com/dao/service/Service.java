package org.solvd.com.dao.service;

import org.solvd.com.dao.Exception.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface Service<P, K> {

    boolean create(P object) throws DAOException, SQLException;

    P read(K id) throws DAOException;

    void update(P object) throws DAOException;

    List<P> getAll(P object) throws DAOException;

    void delete(P object) throws DAOException;
}