package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.ArticleInfoDao;
import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.malfurion.malfurionserver.system.mapper.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<ArticleInfo> selectArticleInfoList() {
        return articleInfoMapper.selectList(null);
    }

    @Override
    public int updateArticleInfo(ArticleInfo articleInfo) {
        QueryWrapper<ArticleInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("info_id", articleInfo.getInfoId());
        return articleInfoMapper.update(articleInfo, wrapper);
    }

    @Override
    public int deleteArticleInfo(long infoId) {
        QueryWrapper<ArticleInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("info_id", infoId);
        return articleInfoMapper.delete(wrapper);
    }

    @Override
    public List<Long> selectArticleIdList() {
        return articleInfoMapper.selectArticleIdList();
    }


}
