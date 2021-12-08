package com.malfurion.malfurionserver.system.dao.impl;

import com.malfurion.malfurionserver.system.dao.ArticleCommentDao;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.mapper.ArticleCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleCommentDaoImpl implements ArticleCommentDao {
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    @Override
    public int insertArticleComment(ArticleComment articleComment) {
        return articleCommentMapper.insert(articleComment);
    }
}
