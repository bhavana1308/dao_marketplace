package org.solvd.com.dao.service;

import org.solvd.com.dao.Exception.DAOException;
import org.solvd.com.dao.model.Category;
import org.solvd.com.dao.utils.GenericDAO;

import java.util.List;

public class CategoryService implements Service<Category, Integer> {

    private final GenericDAO<Category, Integer> categoryDao;

    public CategoryService(GenericDAO<Category, Integer> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public boolean create(Category object) {
        return false;
    }

    @Override
    public Category read(Integer id) throws DAOException {
        return categoryDao.read(id);
    }

    @Override
    public void update(Category entity) throws DAOException {
        categoryDao.update(entity);
    }

    @Override
    public List<Category> getAll(Category entity) throws DAOException {
        return categoryDao.getAll(entity);
    }

    @Override
    public void delete(Category entity) throws DAOException {
        categoryDao.delete(entity);
    }
}