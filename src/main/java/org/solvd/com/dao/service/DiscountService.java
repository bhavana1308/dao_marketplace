package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Discounts;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class DiscountService implements Service<Discounts> {

    private final GenericDao<Discounts> discountsDao;

    public DiscountService(GenericDao<Discounts> discountsDao) {
        this.discountsDao = discountsDao;
    }

    @Override
    public void insert(Discounts entity) {
        discountsDao.insert(entity);
    }

    @Override
    public Discounts findById(int id) {
        return discountsDao.findById(id);
    }


    @Override
    public Discounts update(Discounts entity) {
        return discountsDao.update(entity);
    }

    @Override
    public List<Discounts> getAll() {
        return discountsDao.getAll();
    }

    @Override
    public void delete(Discounts entity) {
        discountsDao.delete(entity);
    }
}
