package org.solvd.com.dao.mybatis;


import org.solvd.com.dao.model.Product;

import java.util.List;

public interface ProductsMapper {

    Product getByProductName(String productName);

    List<Product> getAllFromProducts();

}
