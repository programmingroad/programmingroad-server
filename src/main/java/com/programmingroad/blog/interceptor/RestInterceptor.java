package com.programmingroad.blog.interceptor;

import com.programmingroad.blog.constant.RedisConstant;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.exception.CustomizeException;
import com.programmingroad.blog.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 14:08
 * @description:
 * @version: 1.0
 **/

@Component
public class RestInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = CookieUtil.getToken(request);
        String key = String.format(RedisConstant.TOKEN_PREFIX, token);
        Boolean hasKey = stringRedisTemplate.hasKey(key);
        if (!hasKey) {
            throw new CustomizeException(ResultEnum.UNAUTHORIZED);
        }
        return true;
    }
}
