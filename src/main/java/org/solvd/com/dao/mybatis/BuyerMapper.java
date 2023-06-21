package org.solvd.com.dao.mybatis;

import org.solvd.com.dao.model.Buyer;

import java.util.List;

public interface BuyerMapper {

    List<Buyer> getAllFromBuyer();

    int insertBuyer(Buyer buyer);

    int updateBuyer(Buyer buyer);

    int deleteByBuyerId(int id);


}
