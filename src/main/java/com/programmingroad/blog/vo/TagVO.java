package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:46
 * @description:
 * @version: 1.0
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "TagVO")
public class TagVO {

    @ApiModelProperty(value = "标签id")
    private Long id;

    @ApiModelProperty(value = "标签名称")
    private String name;

    @ApiModelProperty(value = "标签创建时间")
    private Date createTime;

}
