package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.ArticleContent;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface ArticleContentService extends IService<ArticleContent> {

    String insertArticleContent(ArticleContent articleContent);

    String uploadArticleContent(ArticleContent articleContent);
}
