package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleContent;

public interface ArticleContentDao {

    int insertArticleContent(ArticleContent articleContent);

    int updateArticleContent(ArticleContent articleContent);

    ArticleContent selectArticleContentById(Long contentId);

    ArticleContent selectArticleContentByInfoId(Long infoId);

}
