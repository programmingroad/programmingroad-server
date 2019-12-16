package com.programmingroad.blog.handler;

import com.programmingroad.blog.exception.GlobalException;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:29
 * @description:
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    public ResultVO handlerBlogException(GlobalException globalException) {
        return ResultUtil.error(globalException.getResultEnum());
    }
}
