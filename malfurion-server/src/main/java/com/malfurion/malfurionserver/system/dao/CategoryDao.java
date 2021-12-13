package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.Category;

import java.util.List;

public interface CategoryDao {

    Long selectCategoryIdByName(String name);

    int insertCategory(Category category);

    List<Category> selectCategoryList();

    Category selectCategoryById(Long id);

    Category selectCategoryByName(String name);

    int updateCategory(Category category);

    int deleteCategory(long id);
}
