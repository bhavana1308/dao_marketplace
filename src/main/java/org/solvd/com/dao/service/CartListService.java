package org.solvd.com.dao.service;

import org.solvd.com.dao.Exception.DAOException;
import org.solvd.com.dao.model.CartList;
import org.solvd.com.dao.utils.GenericDAO;
import java.util.List;

public class CartListService implements Service<CartList, Integer> {

    private final GenericDAO<CartList, Integer> cartListDao;

    public CartListService(GenericDAO<CartList, Integer> cartListDao) {
        this.cartListDao = cartListDao;
    }

    @Override
    public boolean create(CartList object) {
        return false;
    }

    @Override
    public CartList read(Integer id) throws DAOException {
        return cartListDao.read(id);
    }

    @Override
    public void update(CartList entity) throws DAOException {
        cartListDao.update(entity);
    }

    @Override
    public List<CartList> getAll(CartList entity) throws DAOException {
        return cartListDao.getAll(entity);
    }

    @Override
    public void delete(CartList entity) throws DAOException {
        cartListDao.delete(entity);
    }
}
