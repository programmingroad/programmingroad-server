package com.programmingroad.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.programmingroad.blog.constant.CookieConstant;
import com.programmingroad.blog.constant.RedisConstant;
import com.programmingroad.blog.converter.GithubUserDTO2UserVOConverter;
import com.programmingroad.blog.platform.github.dto.GithubUserDTO;
import com.programmingroad.blog.platform.github.service.GithubService;
import com.programmingroad.blog.service.UserService;
import com.programmingroad.blog.utils.CookieUtil;
import com.programmingroad.blog.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:55
 * @description:
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    GithubService githubService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Value("${github.login}")
    String login;

    @Override
    public UserVO login(String code, HttpServletResponse response) {

        GithubUserDTO githubUserDTO = githubService.getGithubUserByCode(code);

        if (!githubUserDTO.getLogin().equals(login)) {
            // todo 添加权限
        }

        String token = UUID.randomUUID().toString();
        String key = String.format(RedisConstant.TOKEN_PREFIX, token);
        String value = JSON.toJSONString(githubUserDTO);
        // 设置token到redis
        stringRedisTemplate.opsForValue().set(key, value, RedisConstant.EXPIRE, TimeUnit.SECONDS);
        // 配置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);

        UserVO userVO = GithubUserDTO2UserVOConverter.converter(githubUserDTO);

        return userVO;
    }

    @Override
    public void logout(String token, HttpServletResponse response) {

        String key = String.format(RedisConstant.TOKEN_PREFIX, token);

        stringRedisTemplate.delete(key);

        CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
    }

    @Override
    public UserVO getUser(String token) {

        String key = String.format(RedisConstant.TOKEN_PREFIX, token);

        String value = stringRedisTemplate.opsForValue().get(key);

        GithubUserDTO githubUserDTO = JSON.parseObject(value, GithubUserDTO.class);

        UserVO userVO = GithubUserDTO2UserVOConverter.converter(githubUserDTO);

        return userVO;
    }
}
