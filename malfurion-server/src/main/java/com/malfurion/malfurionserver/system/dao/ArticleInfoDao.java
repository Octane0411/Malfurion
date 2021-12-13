package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;

import java.util.List;

public interface ArticleInfoDao {

    int insertArticleInfo(ArticleInfo articleInfo);

    ArticleInfo selectArticleInfoById(long infoId);

    List<ArticleInfo> selectArticleInfoList();

    int updateArticleInfo(ArticleInfo articleInfo);

    int deleteArticleInfo(long infoId);

    List<Long> selectArticleIdList();
}
