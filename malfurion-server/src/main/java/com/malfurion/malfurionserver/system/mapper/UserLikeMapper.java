package com.malfurion.malfurionserver.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.malfurion.malfurionserver.system.entity.UserLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLikeMapper extends BaseMapper<UserLike> {

    List<Long> selectInfoListByUserId(long userId);
}
