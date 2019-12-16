package com.programmingroad.blog.converter;

import com.programmingroad.blog.domain.Article;
import com.programmingroad.blog.dto.ArticleDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author: baoqi.liu
 * @create: 2019/11/27 18:42
 * @description:
 * @version: 1.0
 **/

public class ArticleDTO2ArticleConverter {


    /**
     * ArticleDTO -> Article
     *
     * @param articleDTO
     * @return
     */
    public static Article converter(ArticleDTO articleDTO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDTO, article);
        return article;
    }
}
