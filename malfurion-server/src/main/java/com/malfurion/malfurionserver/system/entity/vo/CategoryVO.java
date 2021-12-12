package com.malfurion.malfurionserver.system.entity.vo;

import com.malfurion.malfurionserver.system.entity.Category;

import java.util.List;

public class CategoryTree {
    //TODO 把分类改成分类树
    private long categoryId;

    private String categoryName;

    private List<Category> categoryChildren;
}
