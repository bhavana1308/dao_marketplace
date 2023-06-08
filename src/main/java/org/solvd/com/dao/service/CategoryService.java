package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class CategoryService implements Service<Category> {

    private final GenericDao<Category> categoryDao;

    public CategoryService(GenericDao<Category> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public void insert(Category entity) {
        categoryDao.insert(entity);
    }

    @Override
    public Category update(Category entity) {
        return categoryDao.update(entity);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public void delete(Category entity) {
        categoryDao.delete(entity);
    }
}