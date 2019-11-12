package com.programmingroad.blog.platform.github.manager;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:10
 * @description:
 **/

public interface GithubManager {

    /**
     * 通过code获取access_token
     *
     * @param code
     * @return
     */
    String getAccessTokenByCode(String code);

    /**
     * 通过access_token获取用户信息
     *
     * @param accessToken
     * @return
     */
    String getGithubUserByAccessToken(String accessToken);

}
