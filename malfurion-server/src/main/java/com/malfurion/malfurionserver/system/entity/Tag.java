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
@ApiModel(value="Tag对象", description="")
public class Tag extends SuperEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签id")
    @TableId(value = "tag_id", type = IdType.AUTO)
    private Long tagId;

    @ApiModelProperty(value = "标签名字")
    private String tagName;



}
