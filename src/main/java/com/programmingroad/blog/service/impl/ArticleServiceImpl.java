package com.programmingroad.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.programmingroad.blog.constant.Constant;
import com.programmingroad.blog.converter.Article2ArticleVOConverter;
import com.programmingroad.blog.converter.ArticleDTO2Article;
import com.programmingroad.blog.domain.Article;
import com.programmingroad.blog.dto.ArticleDTO;
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
    public IPage<ArticleVO> listPage(Integer currPage) {

        Page<Article> articlePage = new Page<>(currPage, Constant.PAGE_SIZE);

        IPage<Article> articleIPage = articleMapper.selectPage(articlePage, Wrappers.<Article>query().orderByDesc("create_time"));

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
