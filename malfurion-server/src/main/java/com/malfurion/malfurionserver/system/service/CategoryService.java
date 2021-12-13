package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.entity.vo.CategoryVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface CategoryService extends IService<Category> {

    String insertCategory(Category category);

    List<Category> selectCategoryList();

    CategoryVO selectCategoryTree();

    String updateCategory(Category category);

    String deleteCategory(long categoryId);
}
