package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.UserLikeDao;
import com.malfurion.malfurionserver.system.entity.UserLike;
import com.malfurion.malfurionserver.system.mapper.UserLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLikeDaoImpl implements UserLikeDao {
    @Autowired
    UserLikeMapper userLikeMapper;
    @Override
    public int insertUserLike(UserLike userLike) {
        return userLikeMapper.insert(userLike);
    }

    @Override
    public List<Object> selectUserLikeListByUserId(long userId) {
        QueryWrapper<UserLike> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.select("info_id");
        return userLikeMapper.selectObjs(wrapper);
    }

    @Override
    public List<Long> selectInfoListByUserId(long userId) {
        return userLikeMapper.selectInfoListByUserId(userId);
    }
}
