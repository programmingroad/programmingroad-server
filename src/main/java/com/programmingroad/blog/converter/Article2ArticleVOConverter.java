package com.programmingroad.blog.converter;

import com.programmingroad.blog.domain.Article;
import com.programmingroad.blog.vo.ArticleVO;
import org.springframework.beans.BeanUtils;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 20:11
 * @description:
 * @version: 1.0
 **/

public class Article2ArticleVOConverter {

    /**
     * Article -> ArticleVO
     *
     * @param article
     * @return
     */
    public static ArticleVO converter(Article article) {
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        return articleVO;
    }
}
