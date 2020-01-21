package com.programmingroad.blog.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.programmingroad.blog.domain.Tag;
import com.programmingroad.blog.mapper.TagMapper;
import com.programmingroad.blog.service.ArticleService;
import com.programmingroad.blog.service.TagService;
import com.programmingroad.blog.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:44
 * @description:
 * @version: 1.0
 **/

@Service
@Slf4j
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleService articleService;

    @Override
    public List<TagVO> list() {
        // 按照 create_time 降序查询
        List<Tag> tags = tagMapper.selectList(Wrappers.<Tag>lambdaQuery().orderByDesc(Tag::getCreateTime));
        return tags.stream().map(tag -> this.tag2TagVOConverter(tag)).collect(Collectors.toList());
    }

    @Override
    public void add(String name) {
        Tag tag = Tag.builder()
                .name(name)
                .build();
        tagMapper.insert(tag);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        tagMapper.deleteById(id);
        articleService.deleteByTagId(id);
    }

    /**
     * Tag -> TagVO
     *
     * @param tag
     * @return
     */
    private TagVO tag2TagVOConverter(Tag tag) {
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag, tagVO);
        return tagVO;
    }
}
