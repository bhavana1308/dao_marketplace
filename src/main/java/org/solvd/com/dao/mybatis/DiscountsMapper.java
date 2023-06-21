package org.solvd.com.dao.mybatis;

import org.solvd.com.dao.model.Discounts;

import java.util.List;

public interface DiscountsMapper {

    List<Discounts> getAllFromDiscounts();

    int insertDiscounts(Discounts Discounts);

    int updateDiscounts(Discounts Discounts);

    int deleteByDiscountsId(int id);

}
