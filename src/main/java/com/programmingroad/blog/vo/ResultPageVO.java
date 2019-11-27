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
@ApiModel(value = "ResultPageVO")
public class ResultPageVO {

    @ApiModelProperty(value = "当前页面")
    private Long currPage;

    @ApiModelProperty(value = "页面条数")
    private Long pageSize;

    @ApiModelProperty(value = "总记录数")
    private Long totalCount;

    @ApiModelProperty(value = "总页数")
    private Long totalPage;
}
