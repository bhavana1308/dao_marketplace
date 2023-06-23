package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Product;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class ProductService implements Service<Product> {

    private final GenericDao<Product> productsDao;

    public ProductService(GenericDao<Product> productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public Product insert(Product entity) {
        return productsDao.insert(entity);
    }

    @Override
    public Product update(Product entity) {
        return productsDao.update(entity);
    }

    @Override
    public Product findById(int id) {
        return productsDao.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productsDao.getAll();
    }

    @Override
    public void delete(Product entity) {
        productsDao.delete(entity);
    }
}

