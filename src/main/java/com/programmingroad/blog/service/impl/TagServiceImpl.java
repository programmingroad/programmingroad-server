package com.programmingroad.blog.service.impl;

import com.programmingroad.blog.converter.TagToTagVoConverter;
import com.programmingroad.blog.domain.Tag;
import com.programmingroad.blog.mapper.TagMapper;
import com.programmingroad.blog.service.TagService;
import com.programmingroad.blog.vo.TagVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    TagMapper tagMapper;

    @Override
    public List<TagVO> list() {

        List<Tag> tags = tagMapper.selectList(null);

        return TagToTagVoConverter.converter(tags);

    }

    @Override
    public void add(String name) {

        Tag tag = new Tag();

        tag.setName(name);

        tagMapper.insert(tag);
    }

    @Override
    public void delete(Long id) {

        tagMapper.deleteById(id);
    }
}
