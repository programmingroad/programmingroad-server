package com.programmingroad.blog.api;

import com.programmingroad.blog.service.UserService;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultVO;
import com.programmingroad.blog.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:08
 * @description:
 **/

@Api(tags = "user")
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserApi {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PutMapping("/login")
    public ResultVO<UserVO> login(@ApiParam(value = "github返回的code", required = true) @RequestParam("code") String code, HttpServletResponse response) {

        log.info("[user]登录参数: code={};", code);

        UserVO userVO = userService.login(code, response);

        return ResultUtil.success(userVO);
    }

    @ApiOperation(value = "通过token获取用户信息")
    @GetMapping("/user")
    public ResultVO<UserVO> getUser(HttpServletRequest request) {

        log.info("[user]通过token获取用户信息");

        UserVO userVO = userService.getUser(request);

        return ResultUtil.success(userVO);
    }
}
