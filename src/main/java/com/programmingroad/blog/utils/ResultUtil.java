package com.programmingroad.blog.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.vo.ResultHeadVO;
import com.programmingroad.blog.vo.ResultPageVO;
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
     * @param resultHeadVO
     * @param object
     * @param resultPageVO
     * @return
     */
    public static ResultVO result(ResultHeadVO resultHeadVO, Object object, ResultPageVO resultPageVO) {

        ResultVO resultVO = new ResultVO();

        resultVO.setHead(resultHeadVO);
        resultVO.setBody(object);
        resultVO.setPage(resultPageVO);


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

        ResultHeadVO resultHeadVO = new ResultHeadVO();

        resultHeadVO.setCode(success.getCode());
        resultHeadVO.setMessage(success.getMessage());

        if (object instanceof IPage) {

            IPage objectIPage = (IPage) object;

            ResultPageVO resultPageVO = new ResultPageVO();

            resultPageVO.setCurrPage(objectIPage.getCurrent());
            resultPageVO.setPageSize(objectIPage.getSize());
            resultPageVO.setTotalCount(objectIPage.getTotal());
            resultPageVO.setTotalPage(objectIPage.getPages());

            return result(resultHeadVO, objectIPage.getRecords(), resultPageVO);
        }

        return result(resultHeadVO, object, null);
    }
}
