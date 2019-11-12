package com.programmingroad.blog.handler;

import com.programmingroad.blog.exception.AuthorizeException;
import com.programmingroad.blog.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:29
 * @description:
 **/

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(value = AuthorizeException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultVO handlerAuthorizeException() {
        // todo
        return null;
    }
}
