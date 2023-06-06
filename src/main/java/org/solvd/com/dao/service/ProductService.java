package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Products;
import org.solvd.com.dao.utils.GenericDao;
import java.util.List;

public class ProductService implements Service<Products, Integer> {

    private final GenericDao<Products, Integer> productsDao;

    public ProductService(GenericDao<Products, Integer> productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public boolean create(Products object) {
        return false;
    }

    @Override
    public Products read(Integer id) throws DaoException {
        return productsDao.read(id);
    }

    @Override
    public void update(Products entity) throws DaoException {
        productsDao.update(entity);
    }

    @Override
    public List<Products> getAll(Products entity) throws DaoException {
        return productsDao.getAll(entity);
    }

    @Override
    public void delete(Products entity) throws DaoException {
        productsDao.delete(entity);
    }
}

