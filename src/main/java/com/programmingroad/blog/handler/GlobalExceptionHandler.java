package com.programmingroad.blog.handler;

import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.exception.CustomizeException;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:29
 * @description:
 **/

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomizeException.class)
    public ResultVO handlerCustomizeException(CustomizeException customizeException) {
        return ResultUtil.error(customizeException.getResultEnum());
    }

    @ExceptionHandler(value = Exception.class)
    public ResultVO handleException() {
        return ResultUtil.error(ResultEnum.INTERNAL_SERVER_ERROR);
    }
}
