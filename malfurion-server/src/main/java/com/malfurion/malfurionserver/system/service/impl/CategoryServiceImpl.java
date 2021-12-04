package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.entity.Category;
import com.malfurion.malfurionserver.system.mapper.CategoryMapper;
import com.malfurion.malfurionserver.system.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
