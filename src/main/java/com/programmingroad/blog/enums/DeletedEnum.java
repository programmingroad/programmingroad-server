package com.programmingroad.blog.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:33
 * @description:
 * @version: 1.0
 **/

@Getter
public enum DeletedEnum {

    /**
     * 未删除
     */
    NOT_DELETE(0, "未删除"),

    /**
     * 已删除
     */
    DELETED(1, "已删除"),

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


    DeletedEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
