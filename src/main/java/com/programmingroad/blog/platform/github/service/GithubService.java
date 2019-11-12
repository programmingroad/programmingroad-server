package com.programmingroad.blog.platform.github.service;

import com.programmingroad.blog.platform.github.dto.GithubUserDTO;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:11
 * @description:
 **/

public interface GithubService {

    /**
     * 通过code获取用户信息
     *
     * @param code
     * @return
     */
    GithubUserDTO getGithubUserByCode(String code);

}
