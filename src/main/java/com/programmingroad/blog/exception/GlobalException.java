package com.programmingroad.blog.exception;

import com.programmingroad.blog.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:21
 * @description:
 **/

@Getter
public class GlobalException extends RuntimeException {

    private ResultEnum resultEnum;

    public GlobalException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
