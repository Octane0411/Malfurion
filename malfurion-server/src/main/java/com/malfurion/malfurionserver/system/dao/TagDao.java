package com.malfurion.malfurionserver.system.dao;

import com.malfurion.malfurionserver.system.entity.Tag;

import java.util.List;

public interface TagDao {

    Long selectTagIdByName(String name);

    int insertTag(Tag tag);

    List<Tag> selectTagList();

    Tag selectTagByName(String name);
}
