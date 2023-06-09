package org.solvd.com.dao.service;

import org.solvd.com.dao.model.Buyer;
import org.solvd.com.dao.utils.GenericDao;

import java.util.List;

public class BuyerService implements Service<Buyer> {

    private final GenericDao<Buyer> buyerDao;

    public BuyerService(GenericDao<Buyer> buyerDao) {
        this.buyerDao = buyerDao;
    }

    @Override
    public Buyer findById(int id) {
        return buyerDao.findById(id);
    }

    @Override
    public Buyer insert(Buyer entity) {
        return buyerDao.insert(entity);
    }

    @Override
    public Buyer update(Buyer entity) {
        return buyerDao.update(entity);
    }

    @Override
    public List<Buyer> getAll() {
        return buyerDao.getAll();
    }

    @Override
    public void delete(Buyer entity) {
        buyerDao.delete(entity);
    }

}
