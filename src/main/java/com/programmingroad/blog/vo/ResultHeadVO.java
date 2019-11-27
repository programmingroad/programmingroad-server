package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 19:26
 * @description:
 * @version: 1.0
 **/

@Data
@ApiModel(value = "ResultHeadVO")
public class ResultHeadVO {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "状态码对应的提示信息")
    private String message;
}
