package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.ArticleContentDao;
import com.malfurion.malfurionserver.system.entity.ArticleContent;
import com.malfurion.malfurionserver.system.mapper.ArticleContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleContentDaoImpl implements ArticleContentDao {

    @Autowired
    ArticleContentMapper articleContentMapper;

    @Override
    public int insertArticleContent(ArticleContent articleContent) {
        return articleContentMapper.insert(articleContent);
    }

    @Override
    public int updateArticleContent(ArticleContent articleContent) {
        QueryWrapper<ArticleContent> wrapper = new QueryWrapper<>();
        wrapper.eq("content_id", articleContent.getContentId());
        return articleContentMapper.update(articleContent, wrapper);
    }

    @Override
    public ArticleContent selectArticleContentById(Long contentId) {
        QueryWrapper<ArticleContent> wrapper = new QueryWrapper<>();
        wrapper.eq("content_id", contentId);
        return articleContentMapper.selectOne(wrapper);
    }

    @Override
    public ArticleContent selectArticleContentByInfoId(Long infoId) {
        QueryWrapper<ArticleContent> wrapper = new QueryWrapper<>();
        wrapper.eq("info_id", infoId);
        return articleContentMapper.selectOne(wrapper);
    }
}
