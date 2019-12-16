package com.programmingroad.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.programmingroad.blog.dto.ArticleDTO;
import com.programmingroad.blog.enums.ReleasedEnum;
import com.programmingroad.blog.vo.ArticleVO;

import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:52
 * @description:
 * @version: 1.0
 **/
public interface ArticleService {

    /**
     * 分页获取文章
     *
     * @param currPage 要获取的页码
     * @param tagId    tagId
     * @param released 是否发布
     * @return
     */
    IPage<ArticleVO> listPage(Integer currPage, Long tagId, ReleasedEnum released);

    /**
     * 添加文章
     *
     * @param articleDTO
     */
    void add(ArticleDTO articleDTO);

    /**
     * 获取指定文章
     *
     * @param id
     * @param released
     * @return
     */
    ArticleVO get(Long id, ReleasedEnum released);

    /**
     * 删除文章
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新文章
     *
     * @param id
     * @param articleDTO
     */
    void update(Long id, ArticleDTO articleDTO);

}
