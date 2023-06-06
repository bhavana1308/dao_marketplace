package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DAOException;
import org.solvd.com.dao.model.Discounts;
import org.solvd.com.dao.utils.GenericDAO;
import java.util.List;

public class DiscountService implements Service<Discounts, Integer> {

    private final GenericDAO<Discounts, Integer> discountsDao;

    public DiscountService(GenericDAO<Discounts, Integer> discountsDao) {
        this.discountsDao = discountsDao;
    }

    @Override
    public boolean create(Discounts object) {
        return false;
    }

    @Override
    public Discounts read(Integer id) throws DAOException {
        return discountsDao.read(id);
    }

    @Override
    public void update(Discounts entity) throws DAOException {
        discountsDao.update(entity);
    }

    @Override
    public List<Discounts> getAll(Discounts entity) throws DAOException {
        return discountsDao.getAll(entity);
    }

    @Override
    public void delete(Discounts entity) throws DAOException {
        discountsDao.delete(entity);
    }
}
