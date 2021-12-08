package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.service.impl.ArticleInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/article-info")
public class ArticleInfoController extends SuperController {

    @Autowired
    ArticleInfoServiceImpl articleInfoService;

    @PostMapping("")
    public AjaxResult insertArticleInfo(@RequestBody ArticleInfo articleInfo) {
        String msg = articleInfoService.insertArticleInfo(articleInfo);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }
}

