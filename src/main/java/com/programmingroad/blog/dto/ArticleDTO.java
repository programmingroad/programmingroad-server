package com.programmingroad.blog.dto;

import com.programmingroad.blog.enums.ReleasedEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:58
 * @description:
 * @version: 1.0
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ArticleDTO")
public class ArticleDTO {

    @ApiModelProperty(value = "标签Id")
    private Long tagId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

}
