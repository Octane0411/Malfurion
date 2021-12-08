package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.mapper.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleInfoDao {

    @Autowired
    ArticleInfoMapper articleInfoMapper;

    public int insertArticleInfo(ArticleInfo articleInfo) {
        return articleInfoMapper.insert(articleInfo);
    }
}
