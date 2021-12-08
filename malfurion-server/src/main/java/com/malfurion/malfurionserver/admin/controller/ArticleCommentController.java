package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.service.impl.ArticleCommentServiceImpl;
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
@RequestMapping("/article-comment")
public class ArticleCommentController extends SuperController {
    @Autowired
    ArticleCommentServiceImpl articleCommentService;

    @PostMapping("")
    public AjaxResult insertArticleComment(@RequestBody ArticleComment articleComment) {
        int i = articleCommentService.insertArticleComment(articleComment);
        return i > 0 ? AjaxResult.success() : AjaxResult.error();
    }

}

