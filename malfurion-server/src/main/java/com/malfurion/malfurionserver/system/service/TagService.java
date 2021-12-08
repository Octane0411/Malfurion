package com.malfurion.malfurionserver.system.service;

import com.malfurion.malfurionserver.system.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
public interface TagService extends IService<Tag> {

    String insertTag(Tag tag);

    List<Tag> selectTagList();
}
