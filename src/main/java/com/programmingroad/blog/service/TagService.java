package com.programmingroad.blog.service;

import com.programmingroad.blog.vo.TagVO;

import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:44
 * @description:
 * @version: 1.0
 **/
public interface TagService {

    /**
     * 获取所有标签
     *
     * @return
     */
    List<TagVO> list();

    /**
     * 添加标签
     *
     * @param name
     */
    void add(String name);

    /**
     * 删除标签
     *
     * @param id
     */
    void delete(Long id);

}
