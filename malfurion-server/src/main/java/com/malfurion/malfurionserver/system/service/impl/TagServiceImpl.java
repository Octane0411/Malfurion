package com.malfurion.malfurionserver.system.service.impl;

import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.mapper.TagMapper;
import com.malfurion.malfurionserver.system.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
