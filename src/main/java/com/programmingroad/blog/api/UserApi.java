package com.programmingroad.blog.api;

import com.programmingroad.blog.constant.CookieConstant;
import com.programmingroad.blog.enums.ResultEnum;
import com.programmingroad.blog.exception.GlobalException;
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

@Api(tags = "UserApi")
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserApi {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ResultVO<UserVO> login(@ApiParam(value = "github返回的code", required = true) @RequestParam("code") String code, HttpServletResponse response) {
        log.info("登录: code={};", code);
        UserVO userVO = userService.login(code, response);
        return ResultUtil.ok(userVO);
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public ResultVO<UserVO> logout(HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.getToken(request);
        log.info("登出: token={};", token);
        userService.logout(token, response);
        return ResultUtil.ok();
    }

    @ApiOperation(value = "通过token获取用户信息")
    @GetMapping("/user")
    public ResultVO<UserVO> getUser(HttpServletRequest request) {
        String token = CookieUtil.getToken(request);
        log.info("获取用户: token={};", token);
        UserVO userVO = userService.getUser(token);
        return ResultUtil.ok(userVO);
    }
}
