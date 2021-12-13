package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.ArticleComment;

import java.util.List;

public interface ArticleCommentDao {

    int insertArticleComment(ArticleComment articleComment);

    List<ArticleComment> selectArticleCommentListByInfoId(long infoId);

    int deleteArticleCommentByCommentId(long commentId);

    int updateArticleComment(ArticleComment articleComment);

    ArticleComment selectArticleCommentById(long commentId);
}
