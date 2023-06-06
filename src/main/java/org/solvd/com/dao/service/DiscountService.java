package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Discounts;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class DiscountService implements Service<Discounts, Integer> {

    private final GenericDao<Discounts, Integer> discountsDao;

    public DiscountService(GenericDao<Discounts, Integer> discountsDao) {
        this.discountsDao = discountsDao;
    }

    @Override
    public boolean create(Discounts object) {
        return false;
    }

    @Override
    public Discounts read(Integer id) throws DaoException {
        return discountsDao.read(id);
    }

    @Override
    public void update(Discounts entity) throws DaoException {
        discountsDao.update(entity);
    }

    @Override
    public List<Discounts> getAll(Discounts entity) throws DaoException {
        return discountsDao.getAll(entity);
    }

    @Override
    public void delete(Discounts entity) throws DaoException {
        discountsDao.delete(entity);
    }
}
