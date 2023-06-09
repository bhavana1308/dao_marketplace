package org.solvd.com.dao.utils;

import java.util.List;

public interface GenericDao<T> {

    T findById(int id);

    List<T> getAll();

    T insert(T entity);

    T update(T entity);

    void delete(T entity);


}

