package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.UserLike;

import java.util.List;

public interface UserLikeDao {

    int insertUserLike(UserLike userLike);

    List<Object> selectUserLikeListByUserId(long userId);

    List<Long> selectInfoListByUserId(long userId);
}
