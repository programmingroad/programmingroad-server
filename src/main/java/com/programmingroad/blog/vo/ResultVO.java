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
@ApiModel(value = "ResultVO")
public class ResultVO<T> {

    @ApiModelProperty(value = "head")
    private ResultHeadVO head;

    @ApiModelProperty(value = "body")
    private T body;

    @ApiModelProperty(value = "page")
    private ResultPageVO page;

}
