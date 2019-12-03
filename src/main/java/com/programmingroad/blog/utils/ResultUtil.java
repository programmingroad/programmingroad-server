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
        return ResultVO.builder()
                .head(resultHeadVO)
                .body(object)
                .page(resultPageVO)
                .build();
    }

    /**
     * 成功+消息体
     *
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultEnum success = ResultEnum.SUCCESS;

        ResultHeadVO resultHeadVO = ResultHeadVO.builder()
                .code(success.getCode())
                .message(success.getMessage())
                .build();

        if (object instanceof IPage) {
            IPage objectIPage = (IPage) object;

            ResultPageVO resultPageVO = ResultPageVO.builder()
                    .currPage(objectIPage.getCurrent())
                    .pageSize(objectIPage.getSize())
                    .totalCount(objectIPage.getTotal())
                    .totalPage(objectIPage.getPages())
                    .build();

            return result(resultHeadVO, objectIPage.getRecords(), resultPageVO);
        }
        return result(resultHeadVO, object, null);
    }
}
