package com.malfurion.malfurionserver.system.mapper;

import com.malfurion.malfurionserver.system.entity.ArticleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    List<Long> selectArticleIdList();
}
