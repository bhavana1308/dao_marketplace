package org.solvd.com.dao.mybatis;


import org.solvd.com.dao.model.Products;

import java.util.List;

public interface ProductsMapper {

    Products getByProductName(String productName);

    List<Products> getAllFromProducts();

    int deleteByProductId(int id);

}
