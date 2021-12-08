package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.common.utils.SecurityUtils;
import com.malfurion.malfurionserver.system.dao.CategoryDao;
import com.malfurion.malfurionserver.system.dao.TagDao;
import com.malfurion.malfurionserver.system.dao.impl.ArticleInfoDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.mapper.ArticleInfoMapper;
import com.malfurion.malfurionserver.system.service.ArticleInfoService;
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
public class ArticleInfoServiceImpl extends ServiceImpl<ArticleInfoMapper, ArticleInfo> implements ArticleInfoService {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ArticleInfoDaoImpl articleInfoDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    TagDao tagDao;

    /**
     * 新建一个博客，内部会将一些初始化的属性置0
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
}
