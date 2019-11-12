package com.programmingroad.blog.exception;

import com.programmingroad.blog.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:21
 * @description:
 **/

@Getter
public class BlogException extends RuntimeException {

    private Integer code;

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }
}
