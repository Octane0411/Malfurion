package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.ArticleCommentDao;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.mapper.ArticleCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCommentDaoImpl implements ArticleCommentDao {
    @Autowired
    ArticleCommentMapper articleCommentMapper;

    @Override
    public int insertArticleComment(ArticleComment articleComment) {
        return articleCommentMapper.insert(articleComment);
    }

    @Override
    public List<ArticleComment> selectArticleCommentListByInfoId(long infoId) {
        QueryWrapper<ArticleComment> wrapper = new QueryWrapper<>();
        wrapper.eq("info_id", infoId);
        return articleCommentMapper.selectList(wrapper);
    }

    @Override
    public int deleteArticleCommentByCommentId(long commentId) {
        QueryWrapper<ArticleComment> wrapper = new QueryWrapper<>();
        wrapper.eq("comment_id", commentId);
        return articleCommentMapper.delete(wrapper);
    }

    @Override
    public int updateArticleComment(ArticleComment articleComment) {
        QueryWrapper<ArticleComment> wrapper = new QueryWrapper<>();
        wrapper.eq("comment_id", articleComment.getCommentId());
        return articleCommentMapper.update(articleComment, wrapper);
    }

    @Override
    public ArticleComment selectArticleCommentById(long commentId) {
        QueryWrapper<ArticleComment> wrapper = new QueryWrapper<>();
        wrapper.eq("comment_id", commentId);
        return articleCommentMapper.selectOne(wrapper);
    }
}
