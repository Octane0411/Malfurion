package com.malfurion.malfurionserver.system.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.malfurion.malfurionserver.system.dao.TagDao;
import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {

    @Autowired
    TagMapper tagMapper;

    @Override
    public Long selectTagIdByName(String name) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("tag_name", name);
        return tagMapper.selectOne(wrapper).getTagId();
    }

    @Override
    public int insertTag(Tag tag) {
        return tagMapper.insert(tag);
    }

    @Override
    public List<Tag> selectTagList() {
        return tagMapper.selectList(null);
    }

    @Override
    public Tag selectTagByName(String name) {
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.eq("tag_name", name);
        return tagMapper.selectOne(wrapper);
    }
}
