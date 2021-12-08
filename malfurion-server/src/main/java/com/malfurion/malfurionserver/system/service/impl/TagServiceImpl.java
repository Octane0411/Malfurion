package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.dao.TagDao;
import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.mapper.TagMapper;
import com.malfurion.malfurionserver.system.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Autowired
    TagDao tagDao;

    @Override
    public String insertTag(Tag tag) {
        String msg = "";
        Tag tag1 = tagDao.selectTagByName(tag.getTagName());
        if (tag1 != null) {
            msg = "该标签已存在";
        } else {
            tagDao.insertTag(tag);
        }
        return msg;
    }

    @Override
    public List<Tag> selectTagList() {
        return tagDao.selectTagList();
    }
}
