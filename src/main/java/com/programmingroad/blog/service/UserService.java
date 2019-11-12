package com.programmingroad.blog.service;

import com.programmingroad.blog.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:55
 * @description:
 **/

public interface UserService {

    /**
     * 登录返回用户信息
     *
     * @param code
     * @param response
     * @return
     */
    UserVO login(String code, HttpServletResponse response);

    /**
     * 通过token获取用户信息
     *
     * @param request
     * @return
     */
    UserVO getUser(HttpServletRequest request);

}
