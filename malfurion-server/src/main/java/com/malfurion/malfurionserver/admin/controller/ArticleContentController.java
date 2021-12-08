package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.ArticleContent;
import com.malfurion.malfurionserver.system.service.impl.ArticleContentServiceImpl;
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
@RequestMapping("/article-content")
public class ArticleContentController extends SuperController {
    @Autowired
    ArticleContentServiceImpl articleContentService;
    @PostMapping("")
    public AjaxResult insertArticleContent(@RequestBody ArticleContent articleContent) {
        String msg = articleContentService.insertArticleContent(articleContent);
        return StringUtils.isEmpty(msg) ? AjaxResult.success():AjaxResult.error(msg);
    }

    @PostMapping("/{id}")
    public AjaxResult updateArticleContent(@RequestBody ArticleContent articleContent, @PathVariable("id") long contentId) {
        String msg = "";
        if (articleContent.getContentId() != contentId) {
            msg = "请求id错误";
        } else {
            msg = articleContentService.uploadArticleContent(articleContent);
        }
        return StringUtils.isEmpty(msg) ? AjaxResult.success() :AjaxResult.error(msg);
    }
}

