package com.programmingroad.blog.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author: baoqi.liu
 * @create: 2019/11/28 15:40
 * @description:
 * @version: 1.0
 **/

@Getter
public enum ReleasedEnum {

    /**
     * 未发布
     */
    NOT_RELEASE(0, "未发布"),

    /**
     * 已发布
     */
    RELEASED(1, "已发布"),
    ;

    /**
     * code码
     */
    @EnumValue
    private Integer code;

    /**
     * 提示消息
     */
    private String message;

    ReleasedEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
