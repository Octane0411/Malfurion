package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.dao.impl.ArticleCommentDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.mapper.ArticleCommentMapper;
import com.malfurion.malfurionserver.system.service.ArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment> implements ArticleCommentService {
    @Autowired
    ArticleCommentDaoImpl articleCommentDao;

    @Override
    public int insertArticleComment(ArticleComment articleComment) {
        //TODO 数据校验
        return articleCommentDao.insertArticleComment(articleComment);
    }
}
