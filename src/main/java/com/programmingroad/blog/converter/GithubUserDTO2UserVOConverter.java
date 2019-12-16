package com.programmingroad.blog.converter;

import com.programmingroad.blog.platform.github.dto.GithubUserDTO;
import com.programmingroad.blog.vo.UserVO;
import org.springframework.beans.BeanUtils;

/**
 * @author: programmingroad
 * @create: 2019/10/06 12:50
 * @description: GithubUserDTO -> UserVO 转换器
 **/

public class GithubUserDTO2UserVOConverter {

    /**
     * GithubUserDTO -> UserVO
     *
     * @param githubUserDTO
     * @return
     */
    public static UserVO converter(GithubUserDTO githubUserDTO) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(githubUserDTO, userVO);
        return userVO;
    }
}
