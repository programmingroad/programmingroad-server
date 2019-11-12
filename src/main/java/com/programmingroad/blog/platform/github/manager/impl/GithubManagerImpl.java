package com.programmingroad.blog.platform.github.manager.impl;

import com.programmingroad.blog.platform.github.constant.GithubConstant;
import com.programmingroad.blog.platform.github.manager.GithubManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:11
 * @description:
 **/

@Component
public class GithubManagerImpl implements GithubManager {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${github.clientId}")
    private String clientId;

    @Value("${github.clientSecret}")
    private String clientSecret;

    @Value("${github.accessTokenUrl}")
    private String accessTokenUrl;

    @Value("${github.userUrl}")
    private String userUrl;


    @Override
    public String getAccessTokenByCode(String code) {

        Map<String, Object> requestMap = new HashMap<>(3);

        requestMap.put(GithubConstant.CLIENT_ID, this.clientId);
        requestMap.put(GithubConstant.CLIENT_SECRET, this.clientSecret);
        requestMap.put(GithubConstant.CODE, code);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestMap, headers);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(this.accessTokenUrl, request, String.class);

        String accessTokenResp = stringResponseEntity.getBody();

        String[] urlArray = accessTokenResp.split("&");

        if (urlArray.length == 0) {
            return null;
        }

        String[] paramArray = urlArray[0].split("=");

        if (paramArray.length == 0) {
            return null;
        }

        String accessToken = paramArray[1];

        return accessToken;
    }

    @Override
    public String getGithubUserByAccessToken(String accessToken) {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity(this.userUrl + "?" + GithubConstant.ACCESS_TOKEN + "=" + accessToken, String.class);

        String githubUserStr = responseEntity.getBody();

        return githubUserStr;
    }
}
