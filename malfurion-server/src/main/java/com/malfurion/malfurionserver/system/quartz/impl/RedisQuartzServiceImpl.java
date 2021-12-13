package com.malfurion.malfurionserver.system.quartz.impl;

import com.malfurion.malfurionserver.common.core.redis.RedisCache;
import com.malfurion.malfurionserver.system.dao.ArticleInfoDao;
import com.malfurion.malfurionserver.system.dao.UserDao;
import com.malfurion.malfurionserver.system.dao.UserLikeDao;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.entity.UserLike;
import com.malfurion.malfurionserver.system.quartz.RedisQuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 执行定时任务
 */
@Service
@EnableScheduling
public class RedisQuartzServiceImpl implements RedisQuartzService {

    private static Logger logger = LoggerFactory.getLogger(RedisQuartzService.class);

    @Autowired
    ArticleInfoDao articleInfoDao;
    @Autowired
    RedisCache redisCache;
    @Autowired
    UserDao userDao;
    @Autowired
    UserLikeDao userLikeDao;

    public static final String infoLikeKey = "infoLike:";
    public static final String infoViewKey = "infoView:";

    public static final String userLikeKey = "userLike:";

    //每十分钟执行一次
    //@Scheduled(cron = "0 */10 * * * ?")
    @Scheduled(cron = "0 0 */1 * * ?")
    @Override
    public void redisInfoToDB() {
        List<Long> idList = articleInfoDao.selectArticleIdList();
        for (Long id : idList) {
            ArticleInfo articleInfo = new ArticleInfo();
            articleInfo.setInfoId(id);


            Integer articleInfoLikes = redisCache.getCacheObject(infoLikeKey + id);
            if (articleInfoLikes == null) {
                continue;
            }
            articleInfo.setLikes(articleInfoLikes);
            Integer articleInfoViews = redisCache.getCacheObject(infoViewKey + id);
            if (articleInfoViews == null) {
                continue;
            }
            articleInfo.setViews(articleInfoViews);
            articleInfoDao.updateArticleInfo(articleInfo);
        }
    }

    @Scheduled(cron = "0 0 */1 * * ?")
    @Override
    public void redisUserLikeToDB() {
        List<Long> idList = userDao.selectUserIdList();
        for (Long userId : idList) {
            List<Long> cacheSet = redisCache.getCacheObject(userLikeKey + userId);
            if (cacheSet == null) {
                continue;
            }
            for (Long infoId : cacheSet) {
                UserLike userLike = new UserLike();
                List<Long> userLikes = userLikeDao.selectInfoListByUserId(userId);
                if (!userLikes.contains(infoId)) {
                    userLike.setUserId(userId);
                    userLike.setInfoId(infoId);
                    userLikeDao.insertUserLike(userLike);
                }
            }
        }
    }
}
