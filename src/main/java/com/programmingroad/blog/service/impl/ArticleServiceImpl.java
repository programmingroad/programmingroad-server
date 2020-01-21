package com.programmingroad.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.programmingroad.blog.constant.Constant;
import com.programmingroad.blog.domain.Article;
import com.programmingroad.blog.dto.ArticleDTO;
import com.programmingroad.blog.enums.ReleasedEnum;
import com.programmingroad.blog.mapper.ArticleMapper;
import com.programmingroad.blog.service.ArticleService;
import com.programmingroad.blog.service.ImageService;
import com.programmingroad.blog.utils.RandomUtil;
import com.programmingroad.blog.vo.ArticleVO;
import com.programmingroad.blog.vo.ImageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private ArticleMapper articleMapper;

    @Autowired
    private ImageService imageService;

    @Override
    public IPage<ArticleVO> listPage(Integer currPage, Long tagId, ReleasedEnum released) {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = Wrappers.<Article>lambdaQuery()
                .select(Article::getId, Article::getTitle, Article::getDescription, Article::getCreateTime);
        // 是否添加 tagId 筛选条件
        if (tagId != null) {
            lambdaQueryWrapper.eq(Article::getTagId, tagId);
        }
        // 是否添加 released 筛选条件
        if (released != null) {
            lambdaQueryWrapper.eq(Article::getReleased, released);
        }
        // 按照 create_time 倒序排列
        lambdaQueryWrapper.orderByDesc(Article::getCreateTime);
        IPage<Article> articleIPage = articleMapper.selectPage(new Page<>(currPage, Constant.PAGE_SIZE), lambdaQueryWrapper);
        return articleIPage.convert(article -> this.article2ArticleVOConverter(article));
    }

    @Override
    public ArticleVO add(ArticleDTO articleDTO) {
        Article article = this.articleDTO2ArticleConverter(articleDTO);
        articleMapper.insert(article);
        return this.article2ArticleVOConverter(article);
    }

    @Override
    public ArticleVO get(Long id, ReleasedEnum released) {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = Wrappers.<Article>lambdaQuery().eq(Article::getId, id);
        if (released != null) {
            lambdaQueryWrapper.eq(Article::getReleased, released);
        }
        Article article = articleMapper.selectOne(lambdaQueryWrapper);
        return this.article2ArticleVOConverter(article);
    }

    @Override
    public void delete(Long id) {
        articleMapper.deleteById(id);
    }

    @Override
    public void deleteByTagId(Long tagId) {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = Wrappers.<Article>lambdaQuery().eq(Article::getTagId, tagId);
        articleMapper.delete(lambdaQueryWrapper);
    }

    @Override
    public void update(Long id, ArticleDTO articleDTO) {
        Article article = this.articleDTO2ArticleConverter(articleDTO);
        article.setId(id);
        articleMapper.updateById(article);
    }

    /**
     * Article -> ArticleVO
     *
     * @param article
     * @return
     */
    private ArticleVO article2ArticleVOConverter(Article article) {
        ArticleVO articleVO = new ArticleVO();
        BeanUtils.copyProperties(article, articleVO);
        articleVO.setCover(this.getRandomCover());
        return articleVO;
    }

    /**
     * ArticleDTO -> Article
     *
     * @param articleDTO
     * @return
     */
    private Article articleDTO2ArticleConverter(ArticleDTO articleDTO) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDTO, article);
        return article;
    }

    /**
     * 随机获取封面图片
     *
     * @return
     */
    private String getRandomCover() {
        List<ImageVO> imageVOS = imageService.listCoverImages();
        Integer index = RandomUtil.getRandom(imageVOS.size());
        return imageVOS.get(index).getUrl();
    }
}
