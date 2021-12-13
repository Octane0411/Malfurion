package com.malfurion.malfurionserver.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.malfurion.malfurionserver.common.core.domain.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="用户收藏记录", description="")
public class UserMark extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户收藏id")
    @TableId(value = "user_mark_id", type = IdType.AUTO)
    private long userMarkId;

    @ApiModelProperty(value = "用户id")
    private long userId;

    @ApiModelProperty(value = "文章id")
    private long infoId;

}
