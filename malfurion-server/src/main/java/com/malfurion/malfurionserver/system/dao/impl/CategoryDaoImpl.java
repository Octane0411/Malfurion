package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.CategoryDao;
import com.malfurion.malfurionserver.system.entity.Category;
import com.malfurion.malfurionserver.system.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Long selectCategoryIdByName(String name) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_name", name);
        return categoryMapper.selectOne(wrapper).getCategoryId();
    }

    @Override
    public int insertCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public List<Category> selectCategoryList() {
        return categoryMapper.selectList(null);
    }

    @Override
    public Category selectCategoryById(Long id) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", id);
        return categoryMapper.selectOne(wrapper);
    }

    @Override
    public Category selectCategoryByName(String name) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_name", name);
        return categoryMapper.selectOne(wrapper);
    }

    @Override
    public int updateCategory(Category category) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", category.getCategoryId());
        return categoryMapper.update(category, wrapper);
    }

    @Override
    public int deleteCategory(long id) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id", id);
        return categoryMapper.delete(wrapper);
    }
}
