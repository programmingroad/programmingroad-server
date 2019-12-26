package com.programmingroad.blog.vo;

import com.programmingroad.blog.enums.ReleasedEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 19:02
 * @description:
 * @version: 1.0
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ArticleVO")
public class ArticleVO {

    @ApiModelProperty(value = "文章id")
    private Long id;

    @ApiModelProperty(value = "标签id")
    private Long tagId;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "是否发布")
    private ReleasedEnum released;

}
