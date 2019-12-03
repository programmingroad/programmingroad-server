package com.programmingroad.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        LambdaQueryWrapper<Article> select = Wrappers.<Article>lambdaQuery()
                .select(Article::getId, Article::getTitle, Article::getCreateTime);
        // 是否添加 tagId 筛选条件
        if (tagId != null) {
            select.eq(Article::getTagId, tagId);
        }
        // 是否添加 released 筛选条件
        if (released != null) {
            select.eq(Article::getReleased, released);
        }
        // 按照 create_time 倒序排列
        select.orderByDesc(Article::getCreateTime);
        IPage<Article> articleIPage = articleMapper.selectPage(new Page<>(currPage, Constant.PAGE_SIZE), select);
        return articleIPage.convert(article -> (Article2ArticleVOConverter.converter(article)));
    }

    @Override
    public void add(ArticleDTO articleDTO) {

        Article article = ArticleDTO2Article.converter(articleDTO);

        articleMapper.insert(article);
    }

    @Override
    public ArticleVO get(Long id, ReleasedEnum released) {
        LambdaQueryWrapper<Article> select = Wrappers.<Article>lambdaQuery().eq(Article::getId, id);
        if (released != null) {
            select.eq(Article::getReleased, released);
        }
        Article article = articleMapper.selectOne(select);
        return Article2ArticleVOConverter.converter(article);
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
