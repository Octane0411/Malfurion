package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.common.web.controller.RegisterController;
import com.malfurion.malfurionserver.system.dao.CategoryDao;
import com.malfurion.malfurionserver.system.entity.Category;
import com.malfurion.malfurionserver.system.entity.vo.CategoryVO;
import com.malfurion.malfurionserver.system.mapper.CategoryMapper;
import com.malfurion.malfurionserver.system.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public CategoryVO selectCategoryTree() {
        List<Category> categories = selectCategoryList();
        CategoryVO categoryVO = categoryListToTree(categories);
        return categoryVO;
    }

    @Override
    public String updateCategory(Category category) {
        String msg = "";
        Category category1 = categoryDao.selectCategoryById(category.getCategoryId());
        if (category1 == null) {
            msg = "分类不存在";
        } else {
            int flag = categoryDao.updateCategory(category);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }

    @Override
    public String deleteCategory(long categoryId) {
        String msg = "";
        Category category1 = categoryDao.selectCategoryById(categoryId);
        if (category1 == null) {
            msg = "分类不存在";
        } else {
            int flag = categoryDao.deleteCategory(categoryId);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }

    //将category转成categoryT=VO
    public CategoryVO categoryListToTree(List<Category> categoryList) {
        CategoryVO head = new CategoryVO(0, "父节点", null);
        process(head, categoryList);
        return head;
    }
    //转成
    public void process(CategoryVO cur, List<Category> categoryList) {
        findChildren(cur, categoryList);
        List<CategoryVO> categoryChildren = cur.getCategoryChildren();
        if (categoryChildren == null) {
            return;
        }
        for (CategoryVO categoryChild : categoryChildren) {
            process(categoryChild, categoryList);
        }
    }

    public void findChildren(CategoryVO cur, List<Category> categoryList) {
        if (cur == null) {
            return;
        }
        for (Category category : categoryList) {
            Long fatherId = category.getCategoryFatherId();
            if (fatherId == null) {
                continue;
            }

            if (fatherId == cur.getCategoryId()) {
                List<CategoryVO> categoryChildren = cur.getCategoryChildren();
                if (categoryChildren == null) {
                    categoryChildren = new ArrayList<CategoryVO>();
                    categoryChildren.add(new CategoryVO(category.getCategoryId(), category.getCategoryName(), null));
                    cur.setCategoryChildren(categoryChildren);
                }else {
                    categoryChildren.add(new CategoryVO(category.getCategoryId(), category.getCategoryName(), null));
                    cur.setCategoryChildren(categoryChildren);
                }
            }
        }
    }
}
