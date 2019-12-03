package com.programmingroad.blog.handler;

import com.programmingroad.blog.exception.BlogException;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultHeadVO;
import com.programmingroad.blog.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: programmingroad
 * @create: 2019/10/07 22:29
 * @description:
 **/

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(value = BlogException.class)
    public ResultVO handlerBlogException(BlogException blogException) {

        ResultHeadVO resultHeadVO = ResultHeadVO.builder()
                .code(blogException.getCode())
                .message(blogException.getMessage())
                .build();

        return ResultUtil.result(resultHeadVO, null, null);
    }
}
