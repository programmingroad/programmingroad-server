package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 17:15
 * @description:
 * @version: 1.0
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ImageVO")
public class ImageVO implements Serializable {

    @ApiModelProperty(value = "uid")
    private Long uid;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "url")
    private String url;

    public Long getUid() {
        return this.id == null ? null : -this.id;
    }
}
