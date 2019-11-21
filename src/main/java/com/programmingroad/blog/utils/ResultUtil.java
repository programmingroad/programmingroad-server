package com.programmingroad.blog.utils;

import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.vo.ResultVO;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:58
 * @description:
 **/
public class ResultUtil {

    /**
     * 返回result
     *
     * @param code
     * @param message
     * @param object
     * @return
     */
    public static ResultVO result(Integer code, String message, Object object) {

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(code);
        resultVO.setMessage(message);
        resultVO.setBody(object);

        return resultVO;
    }

    /**
     * 成功+消息体
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {

        ResultEnum success = ResultEnum.SUCCESS;

        return result(success.getCode(), success.getMessage(), object);
    }
}
