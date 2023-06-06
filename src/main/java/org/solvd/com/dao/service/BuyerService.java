package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class BuyerService implements Service<Buyer, Integer> {

    private final GenericDao<Buyer, Integer> buyerDao;

    public BuyerService(GenericDao<Buyer, Integer> buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Override
    public boolean create(Buyer object) {
        return false;
    }

    @Override
    public Buyer read(Integer id) throws DaoException {
        return buyerDao.read(id);
    }

    @Override
    public void update(Buyer entity) throws DaoException {
        buyerDao.update(entity);
    }

    @Override
    public List<Buyer> getAll(Buyer entity) throws DaoException {
        return buyerDao.getAll(entity);
    }

    @Override
    public void delete(Buyer entity) throws DaoException {
        buyerDao.delete(entity);
    }

}
