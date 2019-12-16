package com.programmingroad.blog.utils;

import com.programmingroad.blog.constant.CookieConstant;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: programmingroad
 * @create: 2019/10/07 13:50
 * @description:
 **/

@Slf4j
public class CookieUtil {

    /**
     * 设置cookie
     *
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        return cookieMap.getOrDefault(name, null);
    }

    /**
     * 读取cookie到map
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>(16);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 获取token
     *
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
        Cookie cookie = get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("cookie为null");
            throw new GlobalException(ResultEnum.UNAUTHORIZED);
        }
        return cookie.getValue();
    }
}
