package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleMark;

import java.util.List;

public interface ArticleMarkDao {

    int insertArticleMark(ArticleMark articleMark);

    List<Long> selectArticleMarkByUserId(long userId);

    int deleteArticleMarkById(long userId, long infoId);
}
