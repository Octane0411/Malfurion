package com.malfurion.malfurionserver.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.entity.UserComment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCommentMapper extends BaseMapper<UserComment> {
}
