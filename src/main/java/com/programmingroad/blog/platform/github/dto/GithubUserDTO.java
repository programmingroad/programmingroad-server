package com.programmingroad.blog.platform.github.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:13
 * @description:
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GithubUserDTO {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户 login
     */
    private String login;

    /**
     * 用户头像 url
     */
    private String avatarUrl;

    /**
     * 用户 github url
     */
    private String htmlUrl;

}
