package com.malfurion.malfurionserver.admin.controller;


import com.malfurion.malfurionserver.common.core.domain.AjaxResult;
import com.malfurion.malfurionserver.common.utils.StringUtils;
import com.malfurion.malfurionserver.system.entity.Tag;
import com.malfurion.malfurionserver.system.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.malfurion.malfurionserver.common.core.controller.SuperController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@RestController
@RequestMapping("/tag")
public class TagController extends SuperController {
    @Autowired
    TagServiceImpl tagService;

    @PostMapping("")
    public AjaxResult insertTag(@RequestBody Tag tag) {
        String msg = tagService.insertTag(tag);
        return StringUtils.isEmpty(msg) ? AjaxResult.success() : AjaxResult.error(msg);
    }

    @GetMapping("")
    public List<Tag> selectTagList() {
        return tagService.selectTagList();
    }
}

