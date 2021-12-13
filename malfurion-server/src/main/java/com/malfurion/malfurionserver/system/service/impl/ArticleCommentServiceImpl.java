package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.common.utils.SecurityUtils;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.dao.impl.ArticleCommentDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleComment;
import com.malfurion.malfurionserver.system.mapper.ArticleCommentMapper;
import com.malfurion.malfurionserver.system.service.ArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
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
    public String insertArticleComment(ArticleComment articleComment) {
        String msg = "";
        long userId = SecurityUtils.getUserId();
        if (articleComment.getCommentId() != null) {
            msg = "请求格式不正确";
        } else if (StringUtils.isEmpty(articleComment.getCommentContent())) {
            msg = "评论不能为空";
        } else if (userId < 0) {
            msg = "未登录无法评论";
        } else {
            articleComment.setUserId(userId);
            int flag = articleCommentDao.insertArticleComment(articleComment);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }

    @Override
    public List<ArticleComment> selectArticleComments(long infoId) {
        return articleCommentDao.selectArticleCommentListByInfoId(infoId);
    }

    @Override
    public String deleteArticleComment(long commentId) {
        String msg = "";
        Long userId = SecurityUtils.getUserId();
        ArticleComment articleComment = articleCommentDao.selectArticleCommentById(commentId);
        if (articleComment == null) {
            msg = "评论不存在";
        } else if (userId != articleComment.getUserId()) {
            msg = "你还想删别人的评论？";
        } else {
            int flag = articleCommentDao.deleteArticleCommentByCommentId(commentId);
            msg = flag > 0 ? "" : "发生错误";
        }
        return msg;
    }

    @Override
    public String updateArticleComment(ArticleComment articleComment) {
        Long userId = SecurityUtils.getUserId();
        String msg = "";
        ArticleComment articleComment1 = articleCommentDao.selectArticleCommentById(articleComment.getCommentId());
        if (articleComment1 == null) {
            msg = "无法更新评论";
        } else if (userId != articleComment1.getUserId()) {
            msg = "无法更新评论";
        } else if (articleComment.getCommentId() == null) {
            msg = "请求格式不正确";
        } else if (StringUtils.isEmpty(articleComment.getCommentContent())) {
            msg = "评论不能为空";
        } else if (userId < 0) {
            msg = "未登录无法评论";
        } else {
            articleComment.setUserId(userId);
            int flag = articleCommentDao.updateArticleComment(articleComment);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }
}
