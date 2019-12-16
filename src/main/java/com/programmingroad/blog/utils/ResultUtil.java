package com.programmingroad.blog.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.vo.ResultHeadVO;
import com.programmingroad.blog.vo.ResultPageVO;
import com.programmingroad.blog.vo.ResultVO;

import java.util.List;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:58
 * @description:
 **/
public class ResultUtil {

    /**
     * result
     *
     * @param resultEnum
     * @param t
     * @param resultPageVO
     * @param <T>
     * @return
     */
    private static <T> ResultVO<T> result(ResultEnum resultEnum, T t, ResultPageVO resultPageVO) {
        ResultHeadVO resultHeadVO = ResultHeadVO.builder()
                .code(resultEnum.getCode())
                .message(resultEnum.getMessage())
                .build();
        return ResultVO.<T>builder()
                .head(resultHeadVO)
                .body(t)
                .page(resultPageVO)
                .build();
    }

    /**
     * ok
     *
     * @param iPage
     * @param <T>
     * @return
     */
    public static <T> ResultVO<List<T>> ok(IPage<T> iPage) {
        ResultPageVO resultPageVO = ResultPageVO.builder()
                .currPage(iPage.getCurrent())
                .pageSize(iPage.getSize())
                .totalCount(iPage.getTotal())
                .totalPage(iPage.getPages())
                .build();
        return result(ResultEnum.OK, iPage.getRecords(), resultPageVO);

    }

    /**
     * ok
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> ok(T t) {
        return result(ResultEnum.OK, t, null);
    }

    /**
     * ok
     *
     * @return
     */
    public static ResultVO ok() {
        return result(ResultEnum.OK, null, null);
    }

    /**
     * error
     *
     * @return
     */
    public static ResultVO error(ResultEnum resultEnum) {
        return result(resultEnum, null, null);
    }
}
