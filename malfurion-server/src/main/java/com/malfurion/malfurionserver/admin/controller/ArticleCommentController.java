package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.controller.SuperController;
import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.service.impl.ArticleCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/article-comment")
public class ArticleCommentController extends SuperController {
    @Autowired
    ArticleCommentServiceImpl articleCommentService;

    @PostMapping("")
    public AjaxResult insertArticleComment(@RequestBody ArticleComment articleComment) {
        String msg = articleCommentService.insertArticleComment(articleComment);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("/{id}")
    public List<ArticleComment> selectArticleCommentsByInfoId(@PathVariable("id") long infoId) {
        return articleCommentService.selectArticleComments(infoId);
    }

    @DeleteMapping("/{id}")
    public AjaxResult deleteArticleComment(@PathVariable("id") long commentId) {
        String msg = articleCommentService.deleteArticleComment(commentId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @PutMapping("/{id}")
    public AjaxResult updateArticleComment(@PathVariable("id") long commentId, @RequestBody ArticleComment articleComment) {
        articleComment.setCommentId(commentId);
        String msg = articleCommentService.updateArticleComment(articleComment);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

}

