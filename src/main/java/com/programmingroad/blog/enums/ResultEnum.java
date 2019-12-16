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
     * OK
     */
    OK(200, "OK"),

    /**
     * Bad Request
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * Unauthorized
     */
    UNAUTHORIZED(401, "Unauthorized"),

    /**
     * Forbidden
     */
    FORBIDDEN(403, "Forbidden"),

    /**
     * Internal Server Error
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
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
