package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.malfurion.malfurionserver.system.service.impl.ArticleMarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.malfurion.malfurionserver.common.core.controller.SuperController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/article-mark")
public class ArticleMarkController extends SuperController {
    @Autowired
    ArticleMarkServiceImpl articleMarkService;

    @PostMapping("")
    public AjaxResult insertArticleMark(@RequestBody ArticleMark articleMark) {
        String msg = articleMarkService.insertArticleMark(articleMark);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error();
    }

}

