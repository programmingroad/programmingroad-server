package com.programmingroad.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.programmingroad.blog.constant.Constant;
import com.programmingroad.blog.converter.Article2ArticleVOConverter;
import com.programmingroad.blog.converter.ArticleDTO2Article;
import com.programmingroad.blog.domain.Article;
import com.programmingroad.blog.dto.ArticleDTO;
import com.programmingroad.blog.enums.ReleasedEnum;
import com.programmingroad.blog.mapper.ArticleMapper;
import com.programmingroad.blog.service.ArticleService;
import com.programmingroad.blog.vo.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:52
 * @description:
 * @version: 1.0
 **/

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public IPage<ArticleVO> listPage(Integer currPage, Long tagId, ReleasedEnum released) {

        Page<Article> articlePage = new Page<>(currPage, Constant.PAGE_SIZE);

        QueryWrapper query = new QueryWrapper();
        // 是否添加 tagId 筛选条件
        if (tagId != null) {
            query.eq("tagId", tagId);
        }
        // 是否添加 released 筛选条件
        if (released != null) {
            query.eq("released", released);
        }
        // 按照 create_time 倒序排列
        query.orderByDesc("create_time");

        IPage<Article> articleIPage = articleMapper.selectPage(articlePage, query);

        return articleIPage.convert(article -> (Article2ArticleVOConverter.converter(article)));

    }

    @Override
    public void add(ArticleDTO articleDTO) {

        Article article = ArticleDTO2Article.converter(articleDTO);

        articleMapper.insert(article);
    }

    @Override
    public void delete(Long id) {

        articleMapper.deleteById(id);
    }

    @Override
    public void update(Long id, ArticleDTO articleDTO) {

        Article article = ArticleDTO2Article.converter(articleDTO);

        article.setId(id);

        articleMapper.updateById(article);
    }
}
