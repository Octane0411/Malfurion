package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface ArticleInfoService extends IService<ArticleInfo> {
    String insertArticleInfo(ArticleInfo articleInfo, String categoryName, String tagName);

    String insertArticleInfo(ArticleInfo articleInfo);

    String updateArticleInfo(ArticleInfo articleInfo);

    String deleteArticleInfo(long articleId);

    List<ArticleInfo> selectArticleInfoList();

    String likeArticle(long infoId);

    String unlikeArticle(long infoId);

    String markArticle(long infoId);

    String unMarkArticle(long infoId);
}
