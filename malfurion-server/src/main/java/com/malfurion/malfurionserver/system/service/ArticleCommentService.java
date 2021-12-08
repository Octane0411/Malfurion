package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.dao.ArticleCommentDao;
import com.malfurion.malfurionserver.system.dao.impl.ArticleCommentDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface ArticleCommentService extends IService<ArticleComment> {
    int insertArticleComment(ArticleComment articleComment);
}
