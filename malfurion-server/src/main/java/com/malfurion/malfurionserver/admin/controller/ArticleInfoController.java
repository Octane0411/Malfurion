package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.service.impl.ArticleInfoServiceImpl;
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
@RequestMapping("/article-info")
public class ArticleInfoController extends SuperController {

    @Autowired
    ArticleInfoServiceImpl articleInfoService;

    @PostMapping("")
    public AjaxResult insertArticleInfo(@RequestBody ArticleInfo articleInfo) {
        String msg = articleInfoService.insertArticleInfo(articleInfo);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("")
    public List<ArticleInfo> selectArticleInfo() {
        return articleInfoService.selectArticleInfoList();
    }

    @PutMapping("/{id}")
    public AjaxResult updateArticleInfo(@RequestBody ArticleInfo articleInfo, @PathVariable("id") long infoId) {
        String msg = articleInfoService.updateArticleInfo(articleInfo);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @DeleteMapping("/{id}")
    public AjaxResult deleteArticleInfo(@PathVariable("id") long infoId) {
        String msg = articleInfoService.deleteArticleInfo(infoId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("/like/{id}")
    public AjaxResult likeArticle(@PathVariable("id") long infoId) {
        String msg = articleInfoService.likeArticle(infoId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("/unlike/{id}")
    public AjaxResult unlikeArticle(@PathVariable("id") long infoId) {
        String msg = articleInfoService.unlikeArticle(infoId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("/mark/{id}")
    public AjaxResult markArticle(@PathVariable("id") long infoId) {
        String msg = articleInfoService.markArticle(infoId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("/unmark/{id}")
    public AjaxResult unmarkArticle(@PathVariable("id") long infoId) {
        String msg = articleInfoService.unMarkArticle(infoId);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }
}

