package com.programmingroad.blog.constant;

/**
 * @author: programmingroad
 * @create: 2019/10/07 13:44
 * @description:
 **/
public interface RedisConstant {

    /**
     * token 前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间 秒
     */
    Integer EXPIRE = 7200;

}
