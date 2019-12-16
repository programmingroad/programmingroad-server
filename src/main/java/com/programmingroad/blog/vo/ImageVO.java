package com.programmingroad.blog.vo;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 17:15
 * @description:
 * @version: 1.0
 **/
@Data
@Builder
@ApiModel(value = "ImageVO")
public class ImageVO {

    private String url;

}
