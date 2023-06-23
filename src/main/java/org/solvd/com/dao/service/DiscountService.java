package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Discount;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class DiscountService implements Service<Discount> {

    private final GenericDao<Discount> discountDao;

    public DiscountService(GenericDao<Discount> discountDao) {
        this.discountDao = discountDao;
    }

    @Override
    public Discount insert(Discount entity) {
        return discountDao.insert(entity);
    }

    @Override
    public Discount findById(int id) {
        return discountDao.findById(id);
    }

    @Override
    public Discount update(Discount entity) {
        return discountDao.update(entity);
    }

    @Override
    public List<Discount> getAll() {
        return discountDao.getAll();
    }

    @Override
    public void delete(Discount entity) {
        discountDao.delete(entity);
    }
}
