package com.malfurion.malfurionserver.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.malfurion.malfurionserver.common.core.domain.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author octane
 * @since 2021-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ArticleInfo对象", description="")
public class ArticleInfo extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章信息id")
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章简介")
    private String summary;

    @ApiModelProperty(value = "文章作者id")
    private Long authorId;

    @ApiModelProperty(value = "文章内容id")
    private Long contentId;

    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "标签id")
    private Long tagId;

    @ApiModelProperty(value = "文章阅读量")
    private Integer views;

    @ApiModelProperty(value = "文章点赞量")
    private Integer likes;

    @ApiModelProperty(value = "收藏量")
    private Integer marks;

    @ApiModelProperty(value = "评论量")
    private Integer comments;



}
