package org.solvd.com.dao.service;

import org.solvd.com.dao.Exception.DAOException;
import org.solvd.com.dao.model.Products;
import org.solvd.com.dao.utils.GenericDAO;

import java.util.List;

public class ProductService implements Service<Products, Integer> {

    private final GenericDAO<Products, Integer> productsDao;

    public ProductService(GenericDAO<Products, Integer> productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public boolean create(Products object) {
        return false;
    }

    @Override
    public Products read(Integer id) throws DAOException {
        return productsDao.read(id);
    }

    @Override
    public void update(Products entity) throws DAOException {
        productsDao.update(entity);
    }

    @Override
    public List<Products> getAll(Products entity) throws DAOException {
        return productsDao.getAll(entity);
    }

    @Override
    public void delete(Products entity) throws DAOException {
        productsDao.delete(entity);
    }
}

