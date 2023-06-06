package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.utils.GenericDao;
import java.util.List;

public class CategoryService implements Service<Category, Integer> {

    private final GenericDao<Category, Integer> categoryDao;

    public CategoryService(GenericDao<Category, Integer> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public boolean create(Category object) {
        return false;
    }

    @Override
    public Category read(Integer id) throws DaoException {
        return categoryDao.read(id);
    }

    @Override
    public void update(Category entity) throws DaoException {
        categoryDao.update(entity);
    }

    @Override
    public List<Category> getAll(Category entity) throws DaoException {
        return categoryDao.getAll(entity);
    }

    @Override
    public void delete(Category entity) throws DaoException {
        categoryDao.delete(entity);
    }
}