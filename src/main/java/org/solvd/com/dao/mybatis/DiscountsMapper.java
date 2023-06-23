package org.solvd.com.dao.mybatis;

import org.solvd.com.dao.model.Discount;

import java.util.List;

public interface DiscountsMapper {

    List<Discount> getAllFromDiscounts();

    int insertDiscounts(Discount Discount);

    int updateDiscounts(Discount Discount);

}
