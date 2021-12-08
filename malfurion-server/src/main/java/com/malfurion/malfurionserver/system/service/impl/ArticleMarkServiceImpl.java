package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.dao.impl.ArticleMarkDaoImpl;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.malfurion.malfurionserver.system.mapper.ArticleMarkMapper;
import com.malfurion.malfurionserver.system.service.ArticleMarkService;
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
public class ArticleMarkServiceImpl extends ServiceImpl<ArticleMarkMapper, ArticleMark> implements ArticleMarkService {
    @Autowired
    ArticleMarkDaoImpl articleMarkDao;
    @Override
    public String insertArticleMark(ArticleMark articleMark) {
        String msg = "";
        int flag = articleMarkDao.insertArticleMark(articleMark);
        if (flag <= 0) {
            msg = "插入错误";
        }
        return msg;
    }
}
