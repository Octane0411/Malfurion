package com.malfurion.malfurionserver.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.system.dao.ArticleContentDao;
import com.malfurion.malfurionserver.system.dao.impl.ArticleInfoDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleContent;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.mapper.ArticleContentMapper;
import com.malfurion.malfurionserver.system.service.ArticleContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentMapper, ArticleContent> implements ArticleContentService {
    private static Logger logger = LoggerFactory.getLogger(ArticleContentService.class);
    @Autowired
    ArticleContentDao articleContentDao;

    @Autowired
    ArticleInfoDaoImpl articleInfoDao;

    @Autowired
    RedisCache redisCache;

    private int expireTime = 30;

    @Override
    public String insertArticleContent(ArticleContent articleContent) {
        String msg = "";
        ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(articleContent.getInfoId());
        if (articleInfo == null) {
            msg = "没有找到对应文章信息";
        } else {
            ArticleContent articleContent1 = articleContentDao.selectArticleContentById(articleContent.getContentId());
            if (articleContent1 != null) {
                msg = "请发送更新请求";
            } else {
                int flag = articleContentDao.insertArticleContent(articleContent);
                if (flag <= 0) {
                    msg = "插入时发生错误";
                }
            }
        }
        return msg;
    }

    @Override
    public String uploadArticleContent(ArticleContent articleContent) {
        String msg = "";
        ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(articleContent.getInfoId());
        if (articleInfo == null) {
            msg = "没有找到对应文章信息";
        } else {
            int flag = articleContentDao.updateArticleContent(articleContent);
            if (flag <= 0) {
                msg = "更新时发生错误";
            }
        }
        return msg;
    }

    public ArticleContent selectArticleContentById(long contentId) {
        ArticleContent articleContent = articleContentDao.selectArticleContentById(contentId);
        if (articleContent != null) {
            saveViewsInfoToRedis(articleContent.getInfoId());
        }
        return articleContent;
    }

    public ArticleContent selectArticleContentByInfoId(long infoId) {
        ArticleContent articleContent = articleContentDao.selectArticleContentByInfoId(infoId);
        if (articleContent != null) {
            saveViewsInfoToRedis(articleContent.getInfoId());
        }
        return articleContent;
    }

    public void saveViewsInfoToRedis(long infoId) {
        String infoKey = "infoView:" + infoId;
        Integer articleInfoView =  redisCache.getCacheObject(infoKey);
        if (articleInfoView == null) {
            articleInfoView = 0;
        }
        articleInfoView++;
        redisCache.setCacheObject(infoKey, articleInfoView);
    }
}
