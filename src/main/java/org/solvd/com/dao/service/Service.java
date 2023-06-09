package org.solvd.com.dao.service;

import java.util.List;

public interface Service<T> {

    T findById(int id);

    List<T> getAll();

    T insert(T entity);

    T update(T entity);

    void delete(T entity);


}