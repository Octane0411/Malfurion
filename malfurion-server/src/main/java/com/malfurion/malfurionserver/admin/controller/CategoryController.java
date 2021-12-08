package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.Category;
import com.malfurion.malfurionserver.system.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.malfurion.malfurionserver.common.core.controller.SuperController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends SuperController {

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("")
    public AjaxResult insertCategory(@RequestBody Category category) {
        String msg = categoryService.insertCategory(category);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("")
    public List<Category> selectCategoryList() {
        return categoryService.selectCategoryList();
    }

}

