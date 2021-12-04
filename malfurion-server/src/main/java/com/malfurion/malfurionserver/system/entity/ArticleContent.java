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
@ApiModel(value="ArticleContent对象", description="")
public class ArticleContent extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "内容id")
    @TableId(value = "content_id", type = IdType.AUTO)
    private Long contentId;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "信息id")
    private Long infoId;

    private Integer deleted;

    @TableLogic
    private Integer version;


}
