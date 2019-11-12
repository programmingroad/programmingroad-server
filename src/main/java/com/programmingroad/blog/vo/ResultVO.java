package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:55
 * @description:
 **/

@Data
@ApiModel(value = "结果返回体")
public class ResultVO<T> {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "状态码对应的提示信息")
    private String message;

    @ApiModelProperty(value = "返回体")
    private T body;

}
