package com.malfurion.malfurionserver.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.common.utils.SecurityUtils;
import com.malfurion.malfurionserver.system.dao.ArticleMarkDao;
import com.malfurion.malfurionserver.system.dao.CategoryDao;
import com.malfurion.malfurionserver.system.dao.TagDao;
import com.malfurion.malfurionserver.system.dao.UserDao;
import com.malfurion.malfurionserver.system.dao.impl.ArticleInfoDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.malfurion.malfurionserver.system.entity.User;
import com.malfurion.malfurionserver.system.mapper.ArticleInfoMapper;
import com.malfurion.malfurionserver.system.service.ArticleContentService;
import com.malfurion.malfurionserver.system.service.ArticleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {
    private static Logger logger = LoggerFactory.getLogger(ArticleContentService.class);

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserDao userDao;

    @Autowired
    ArticleInfoDaoImpl articleInfoDao;

    @Autowired
    ArticleMarkDao articleMarkDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    TagDao tagDao;

    @Autowired
    RedisCache redisCache;

    private int expireTime = 30;

    /**
     * 新建一个博客，内部会将一些初始化的属性置0
     *
     * @param articleInfo
     * @return
     */
    @Override
    public String insertArticleInfo(ArticleInfo articleInfo, String categoryName, String tagName) {
        String msg = "";
        Long userId = SecurityUtils.getUserId();
        Long categoryId = categoryDao.selectCategoryIdByName(categoryName);
        Long tagId = tagDao.selectTagIdByName(tagName);
        articleInfo.setAuthorId(userId);
        articleInfo.setViews(0);
        articleInfo.setLikes(0);
        articleInfo.setMarks(0);
        articleInfo.setComments(0);
        articleInfo.setCategoryId(categoryId);
        articleInfo.setTagId(tagId);

        if (articleInfoDao.insertArticleInfo(articleInfo) <= 0) {
            msg = "发生错误";
        }
        return msg;
    }

    /**
     * 新建一个博客，如果前端已经传了分类和标签的id
     *
     * @param articleInfo
     * @return
     */
    @Override
    public String insertArticleInfo(ArticleInfo articleInfo) {
        String msg = "";
        Long userId = SecurityUtils.getUserId();
        articleInfo.setAuthorId(userId);
        articleInfo.setViews(0);
        articleInfo.setLikes(0);
        articleInfo.setMarks(0);
        articleInfo.setComments(0);
        if (articleInfo.getCategoryId() == null) {
            msg = "未选择分类";
        } else {
            int flag = articleInfoDao.insertArticleInfo(articleInfo);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }

        return msg;
    }

    @Override
    public String updateArticleInfo(ArticleInfo articleInfo) {
        String msg = "";
        ArticleInfo articleInfo1 = articleInfoDao.selectArticleInfoById(articleInfo.getInfoId());
        if (articleInfo1 == null) {
            msg = "文章信息不存在";
        } else {
            int flag = articleInfoDao.updateArticleInfo(articleInfo);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }

    @Override
    public String deleteArticleInfo(long articleId) {
        String msg = "";
        ArticleInfo articleInfo1 = articleInfoDao.selectArticleInfoById(articleId);
        if (articleInfo1 == null) {
            msg = "文章信息不存在";
        } else {
            int flag = articleInfoDao.deleteArticleInfo(articleId);
            if (flag <= 0) {
                msg = "发生错误";
            }
        }
        return msg;
    }

    @Override
    public List<ArticleInfo> selectArticleInfoList() {
        return articleInfoDao.selectArticleInfoList();
    }

    @Override
    public String likeArticle(long infoId) {
        long userId = -1;
        String msg = "";

        userId = SecurityUtils.getUserId();
        if (userId < 0) {
            msg = "未登录，点赞成功，但系统无法储存您的点赞信息";
        } else {
            User user = userDao.selectUserById(userId);
            if (user == null) {
                msg = "用户不存在";
                return msg;
            }
        }

        ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(infoId);
        if (articleInfo == null) {
            msg = "文章不存在";
            return msg;
        }

        String infoLikeKey = "infoLike:" + infoId;
        String userLikeKey = "userLike:" + userId;

        if (userId > 0) {
            //用户点赞的文章+1
            List<Long> cacheSet = redisCache.getCacheObject(userLikeKey);
            if (cacheSet == null) {
                cacheSet = new ArrayList<>();
            }
            if (cacheSet.contains(infoId)) {
                msg = "已经点赞过该文章";
                //不再统计文章的点赞数
                return msg;
            } else {
                cacheSet.add(infoId);
            }
            redisCache.setCacheObject(userLikeKey, cacheSet);
        }

        //文章点赞数+1
        Integer cachedLike = redisCache.getCacheObject(infoLikeKey);
        if (cachedLike == null) {
            redisCache.setCacheObject(infoLikeKey, 1);
        } else {
            redisCache.setCacheObject(infoLikeKey, cachedLike + 1);
        }

        return msg;
    }

    @Override
    public String unlikeArticle(long infoId) {
        long userId = -1;
        String msg = "";

        userId = SecurityUtils.getUserId();
        if (userId < 0) {
            msg = "未登录，点赞成功，但系统无法储存您的点赞信息";
        } else {
            User user = userDao.selectUserById(userId);
            if (user == null) {
                msg = "用户不存在";
                return msg;
            }
        }
        ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(infoId);
        if (articleInfo == null) {
            msg = "文章不存在";
            return msg;
        }

        String infoLikeKey = "infoLike:" + infoId;
        String userLikeKey = "userLike:" + userId;

        if (userId > 0) {
            //用户点赞的文章-1
            List<Long> cacheSet = redisCache.getCacheObject(userLikeKey);
            if (cacheSet == null) {
                cacheSet = new ArrayList<>();
            }
            if (cacheSet.contains(infoId)) {
                cacheSet.remove(infoId);
            } else {
                msg = "发生错误，请联系开发者";
            }
            redisCache.setCacheObject(userLikeKey, cacheSet);
        }

        //文章点赞数-1
        Integer cachedLike = redisCache.getCacheObject(infoLikeKey);
        if (cachedLike == null) {
            msg = "文章不存在";
        } else {
            redisCache.setCacheObject(infoLikeKey, cachedLike - 1);
        }

        return msg;
    }

    @Override
    public String markArticle(long infoId) {
        long userId = -1;
        String msg = "";
        userId = SecurityUtils.getUserId();
        if (userId > 0) {
            List<Long> markList = articleMarkDao.selectArticleMarkByUserId(userId);
            if (markList.contains(infoId)) {
                msg = "已经收藏该文章";
            } else {
                ArticleMark articleMark = new ArticleMark();
                articleMark.setInfoId(infoId);
                articleMark.setUserId(userId);
                articleMarkDao.insertArticleMark(articleMark);
                //TODO缓存优化
                ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(infoId);
                articleInfo.setMarks(articleInfo.getMarks() + 1);
                articleInfoDao.updateArticleInfo(articleInfo);
            }
        } else {
            msg = "未登录无法收藏";
        }
        return msg;
    }

    @Override
    public String unMarkArticle(long infoId) {
        long userId = -1;
        String msg = "";
        userId = SecurityUtils.getUserId();
        if (userId > 0) {
            List<Long> markList = articleMarkDao.selectArticleMarkByUserId(userId);
            if (!markList.contains(infoId)) {
                msg = "未收藏该文章";
            } else {
                articleMarkDao.deleteArticleMarkById(userId, infoId);
                //TODO缓存优化
                ArticleInfo articleInfo = articleInfoDao.selectArticleInfoById(infoId);
                articleInfo.setMarks(articleInfo.getMarks() - 1);
                articleInfoDao.updateArticleInfo(articleInfo);
            }
        } else {
            msg = "未登录无法收藏";
        }
        return msg;
    }

    public boolean likeArticleValidate(long infoId, long userId) {
        String infoLikeKey = "infoLike:" + infoId;
        String userLikeKey = "userLike:" + userId;
        Set<Object> cacheSet = redisCache.getCacheSet(userLikeKey);
        return cacheSet.contains(infoId);
    }
}
