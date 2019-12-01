package com.programmingroad.blog.api;

import com.programmingroad.blog.constant.CookieConstant;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.exception.BlogException;
import com.programmingroad.blog.service.UserService;
import com.programmingroad.blog.utils.CookieUtil;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultVO;
import com.programmingroad.blog.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:08
 * @description:
 **/

@Api(tags = "User")
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserApi {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ResultVO<UserVO> login(@ApiParam(value = "github返回的code", required = true) @RequestParam("code") String code, HttpServletResponse response) {

        log.info("【User】登录参数: code={};", code);

        UserVO userVO = userService.login(code, response);

        return ResultUtil.success(userVO);
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public ResultVO<UserVO> logout(HttpServletRequest request, HttpServletResponse response) {

        String token = this.getToken(request);

        log.info("【User】登出参数: token={};", token);

        userService.logout(token, response);

        return ResultUtil.success(null);
    }

    @ApiOperation(value = "通过token获取用户信息")
    @GetMapping("/user")
    public ResultVO<UserVO> getUser(HttpServletRequest request) {

        String token = this.getToken(request);

        log.info("【User】获取用户参数: token={};", token);

        UserVO userVO = userService.getUser(token);

        return ResultUtil.success(userVO);
    }


    /**
     * 获取token
     *
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie == null) {

            log.warn("cookie为null");

            throw new BlogException(ResultEnum.ERROR);
        }

        return cookie.getValue();
    }
}
