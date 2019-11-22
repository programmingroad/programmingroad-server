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
    NOT_DELETE((byte) 0, "未删除"),

    /**
     * 已删除
     */
    DELETED((byte) 1, "已删除"),

    ;

    /**
     * code码
     */
    @EnumValue
    private Byte code;

    /**
     * 提示消息
     */
    private String message;


    DeletedEnum(Byte code, String message) {
        this.code = code;
        this.message = message;
    }
}
