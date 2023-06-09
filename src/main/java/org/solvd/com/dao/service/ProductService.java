package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Products;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class ProductService implements Service<Products> {

    private final GenericDao<Products> productsDao;

    public ProductService(GenericDao<Products> productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public Products insert(Products entity) {
        return productsDao.insert(entity);
    }

    @Override
    public Products update(Products entity) {
        return productsDao.update(entity);
    }

    @Override
    public Products findById(int id) {
        return productsDao.findById(id);
    }

    @Override
    public List<Products> getAll() {
        return productsDao.getAll();
    }

    @Override
    public void delete(Products entity) {
        productsDao.delete(entity);
    }
}

