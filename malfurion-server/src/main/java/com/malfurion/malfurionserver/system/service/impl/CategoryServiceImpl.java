package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.common.web.controller.RegisterController;
import com.malfurion.malfurionserver.system.dao.CategoryDao;
import com.malfurion.malfurionserver.system.entity.Category;
import com.malfurion.malfurionserver.system.mapper.CategoryMapper;
import com.malfurion.malfurionserver.system.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public String insertCategory(Category category) {
        long fatherId = category.getCategoryFatherId();
        logger.info(String.valueOf("fatherId: " + fatherId));
        String msg = "";
        Category category1 = categoryDao.selectCategoryById(fatherId);
        if (category1 == null) {
            msg = "父节点不存在";
        } else {
            Category category2 = categoryDao.selectCategoryByName(category.getCategoryName());
            if (category2 != null) {
                msg = "该分类已存在";
            } else {
                categoryDao.insertCategory(category);
            }
        }
        return msg;
    }

    @Override
    public List<Category> selectCategoryList() {
        return categoryDao.selectCategoryList();
    }
}
