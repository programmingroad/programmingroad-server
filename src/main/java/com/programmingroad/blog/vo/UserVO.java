package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:49
 * @description:
 **/

@Data
@ApiModel(value = "用户返回体")
public class UserVO {

    @ApiModelProperty(value = "用户id")
    private Long id;

    @ApiModelProperty(value = "用户login")
    private String login;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "用户github地址")
    private String htmlUrl;

}
