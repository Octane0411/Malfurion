package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.ArticleMark;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface ArticleMarkService extends IService<ArticleMark> {
    String insertArticleMark(ArticleMark articleMark);

}
