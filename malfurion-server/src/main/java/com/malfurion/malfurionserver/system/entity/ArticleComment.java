package com.malfurion.malfurionserver.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.malfurion.malfurionserver.common.core.domain.entity.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="ArticleComment对象", description="")
public class ArticleComment extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    @ApiModelProperty(value = "评论内容")
    private String commentContent;

    @ApiModelProperty(value = "评论者id")
    private Long userId;

    @ApiModelProperty(value = "评论的评论id，如果为空，则评论指向文章")
    private Long srcCommentId;

    @ApiModelProperty(value = "信息id")
    private Long infoId;

    @TableLogic
    private Integer version;

    private Integer deleted;


}
