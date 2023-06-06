package org.solvd.com.dao.service;

import org.solvd.com.dao.exception.DaoException;
import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.utils.GenericDao;
import java.util.List;

public class CartListService implements Service<CartList, Integer> {

    private final GenericDao<CartList, Integer> cartListDao;

    public CartListService(GenericDao<CartList, Integer> cartListDao) {
        this.cartListDao = cartListDao;
    }

    @Override
    public boolean create(CartList object) {
        return false;
    }

    @Override
    public CartList read(Integer id) throws DaoException {
        return cartListDao.read(id);
    }

    @Override
    public void update(CartList entity) throws DaoException {
        cartListDao.update(entity);
    }

    @Override
    public List<CartList> getAll(CartList entity) throws DaoException {
        return cartListDao.getAll(entity);
    }

    @Override
    public void delete(CartList entity) throws DaoException {
        cartListDao.delete(entity);
    }
}
