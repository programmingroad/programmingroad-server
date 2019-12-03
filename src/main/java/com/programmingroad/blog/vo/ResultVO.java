package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:55
 * @description:
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ResultVO")
public class ResultVO<T> {

    @ApiModelProperty(value = "head")
    private ResultHeadVO head;

    @ApiModelProperty(value = "body")
    private T body;

    @ApiModelProperty(value = "page")
    private ResultPageVO page;

}
