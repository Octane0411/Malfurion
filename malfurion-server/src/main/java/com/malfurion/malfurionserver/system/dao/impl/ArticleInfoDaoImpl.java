package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.ArticleInfoDao;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.mapper.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleInfoDaoImpl implements ArticleInfoDao {

    @Autowired
    ArticleInfoMapper articleInfoMapper;

    public int insertArticleInfo(ArticleInfo articleInfo) {
        return articleInfoMapper.insert(articleInfo);
    }

    @Override
    public ArticleInfo selectArticleInfoById(long infoId) {
        QueryWrapper<ArticleInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("info_id", infoId);
        return articleInfoMapper.selectOne(wrapper);
    }

}
