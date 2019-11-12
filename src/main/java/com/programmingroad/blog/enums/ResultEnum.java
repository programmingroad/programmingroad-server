package com.programmingroad.blog.enums;

import lombok.Getter;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:58
 * @description:
 **/

@Getter
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 服务器错误
     */
    ERROR(-1, "服务器错误"),


    ;

    /**
     * code码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
