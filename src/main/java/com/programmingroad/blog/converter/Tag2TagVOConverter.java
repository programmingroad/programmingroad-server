package com.programmingroad.blog.converter;

import com.programmingroad.blog.domain.Tag;
import com.programmingroad.blog.vo.TagVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: baoqi.liu
 * @create: 2019/11/21 15:51
 * @description:
 * @version: 1.0
 **/
public class Tag2TagVOConverter {

    /**
     * Tag -> TagVO
     *
     * @param tag
     * @return
     */
    public static TagVO converter(Tag tag) {
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag, tagVO);
        return tagVO;
    }

    /**
     * List<Tag> -> List<TagVO>
     *
     * @param tags
     * @return
     */
    public static List<TagVO> converter(List<Tag> tags) {
        List<TagVO> tagVOS = tags.stream().map(tag -> converter(tag)).collect(Collectors.toList());
        return tagVOS;
    }
}
