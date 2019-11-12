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
     * @param resultEnum
     * @return
     */
    private static ResultVO result(ResultEnum resultEnum, Object object) {

        ResultVO resultVO = new ResultVO();

        resultVO.setCode(resultEnum.getCode());
        resultVO.setMessage(resultEnum.getMessage());
        resultVO.setBody(object);

        return resultVO;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 成功+消息体
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {

        ResultEnum success = ResultEnum.SUCCESS;

        return result(success, object);
    }

    /**
     * 错误
     *
     * @return
     */
    public static ResultVO error() {

        ResultEnum error = ResultEnum.ERROR;

        return result(error, null);
    }
}
