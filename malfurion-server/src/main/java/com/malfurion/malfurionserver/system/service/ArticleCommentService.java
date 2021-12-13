package com.malfurion.malfurionserver.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.malfurion.malfurionserver.system.entity.ArticleComment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface ArticleCommentService extends IService<ArticleComment> {
    String insertArticleComment(ArticleComment articleComment);

    List<ArticleComment> selectArticleComments(long infoId);

    String deleteArticleComment(long commentId);

    String updateArticleComment(ArticleComment articleComment);
}
