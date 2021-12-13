package com.malfurion.malfurionserver.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.malfurion.malfurionserver.system.entity.ArticleMark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Mapper
public interface ArticleMarkMapper extends BaseMapper<ArticleMark> {
    List<Long> selectArticleMarkByUserId(long userId);
}
