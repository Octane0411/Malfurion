package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.ArticleMarkDao;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.malfurion.malfurionserver.system.mapper.ArticleMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleMarkDaoImpl implements ArticleMarkDao {
    @Autowired
    ArticleMarkMapper articleMarkMapper;
    @Override
    public int insertArticleMark(ArticleMark articleMark) {
        return articleMarkMapper.insert(articleMark);
    }

    @Override
    public List<Long> selectArticleMarkByUserId(long userId) {
        return articleMarkMapper.selectArticleMarkByUserId(userId);
    }

    @Override
    public int deleteArticleMarkById(long userId, long infoId) {
        QueryWrapper<ArticleMark> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("info_id", infoId);
        return articleMarkMapper.delete(wrapper);
    }
}
