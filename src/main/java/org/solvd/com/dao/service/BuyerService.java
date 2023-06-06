package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DAOException;
import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.GenericDAO;

import java.util.List;

public class BuyerService implements Service<Buyer, Integer> {

    private final GenericDAO<Buyer, Integer> buyerDao;

    public BuyerService(GenericDAO<Buyer, Integer> buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Override
    public boolean create(Buyer object) {
        return false;
    }

    @Override
    public Buyer read(Integer id) throws DAOException {
        return buyerDao.read(id);
    }

    @Override
    public void update(Buyer entity) throws DAOException {
        buyerDao.update(entity);
    }

    @Override
    public List<Buyer> getAll(Buyer entity) throws DAOException {
        return buyerDao.getAll(entity);
    }

    @Override
    public void delete(Buyer entity) throws DAOException {
        buyerDao.delete(entity);
    }

}
