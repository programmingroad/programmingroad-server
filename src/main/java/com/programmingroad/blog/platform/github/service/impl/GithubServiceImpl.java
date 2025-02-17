package com.programmingroad.blog.platform.github.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.programmingroad.blog.platform.github.constant.GithubConstant;
import com.programmingroad.blog.platform.github.dto.GithubUserDTO;
import com.programmingroad.blog.platform.github.manager.GithubManager;
import com.programmingroad.blog.platform.github.service.GithubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:11
 * @description:
 **/

@Service
@Slf4j
public class GithubServiceImpl implements GithubService {

    @Autowired
    private GithubManager githubManager;

    @Override
    public GithubUserDTO getGithubUserByCode(String code) {
        String accessToken = githubManager.getAccessTokenByCode(code);
        log.info("通过code获取accessToken: code={}, accessToken={};", code, accessToken);
        String githubUserStr = githubManager.getGithubUserByAccessToken(accessToken);
        log.info("通过accessToken获取用户信息: accessToken={}, user={};", accessToken, githubUserStr);
        JSONObject jsonObject = JSON.parseObject(githubUserStr);
        GithubUserDTO githubUserDTO = GithubUserDTO.builder()
                .id(jsonObject.getLong(GithubConstant.ID))
                .login(jsonObject.getString(GithubConstant.LOGIN))
                .avatarUrl(jsonObject.getString(GithubConstant.AVATAR_URL))
                .htmlUrl(jsonObject.getString(GithubConstant.HTML_URL))
                .build();
        log.info("生成dto: githubUserDTO={};", githubUserDTO);
        return githubUserDTO;
    }
}
