package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;

public interface ArticleInfoDao {

    int insertArticleInfo(ArticleInfo articleInfo);

    ArticleInfo selectArticleInfoById(long infoId);
}
