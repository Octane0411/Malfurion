package com.malfurion.malfurionserver.system.dao.impl;

import com.malfurion.malfurionserver.system.dao.ArticleMarkDao;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.malfurion.malfurionserver.system.mapper.ArticleMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleMarkDaoImpl implements ArticleMarkDao {
    @Autowired
    ArticleMarkMapper articleMarkMapper;
    @Override
    public int insertArticleMark(ArticleMark articleMark) {
        return articleMarkMapper.insert(articleMark);
    }
}
