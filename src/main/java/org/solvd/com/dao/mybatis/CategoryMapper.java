package org.solvd.com.dao.mybatis;

import org.solvd.com.dao.model.Category;

import java.util.List;

public interface CategoryMapper {

    Category getByCategoryId(int id);

    List<Category> getAllFromCategory();

    int insertCategory(Category Category);

    int updateCategory(Category Category);

}
