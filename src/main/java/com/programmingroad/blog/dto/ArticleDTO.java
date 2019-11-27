package com.programmingroad.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:58
 * @description:
 * @version: 1.0
 **/

@Data
@ApiModel(value = "ArticleDTO")
public class ArticleDTO {

    @ApiModelProperty(value = "标签Id")
    private Long tagId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

}
