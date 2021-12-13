package com.malfurion.malfurionserver.system.mapper;

import com.malfurion.malfurionserver.system.entity.User;
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
public interface UserMapper extends BaseMapper<User> {
    int insertUser(User user);

    List<User> selectUserList();

    List<Long> selectUserIdList();
}
