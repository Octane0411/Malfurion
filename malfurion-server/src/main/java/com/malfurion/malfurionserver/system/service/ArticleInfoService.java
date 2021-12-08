package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
