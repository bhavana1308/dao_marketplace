package org.solvd.com.dao.mybatis;

import org.solvd.com.dao.model.CartList;

import java.util.List;

public interface CartListMapper {

    CartList getByCartListId(int id);

    List<CartList> getAllFromCartList();

    int deleteByCartListId(int id);

}
