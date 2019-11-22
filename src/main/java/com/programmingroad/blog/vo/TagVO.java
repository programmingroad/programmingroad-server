package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:46
 * @description:
 * @version: 1.0
 **/

@Data
@ApiModel(value = "标签返回体")
public class TagVO {

    @ApiModelProperty(value = "标签id")
    private Long id;

    @ApiModelProperty(value = "标签名称")
    private String name;

    @ApiModelProperty(value = "标签创建时间")
    private Date createTime;

}
