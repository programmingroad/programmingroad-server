package com.programmingroad.blog.converter;

import com.programmingroad.blog.domain.Cover;
import com.programmingroad.blog.vo.ImageVO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: baoqi.liu
 * @create: 2020/1/20 15:11
 * @description:
 * @version: 1.0
 **/
public class Cover2ImageVOConverter {

    /**
     * Cover -> ImageVO
     *
     * @param cover
     * @return
     */
    public static ImageVO converter(Cover cover) {
        ImageVO imageVO = new ImageVO();
        BeanUtils.copyProperties(cover, imageVO);
        return imageVO;
    }

    /**
     * List<Cover> -> List<ImageVO>
     *
     * @param covers
     * @return
     */
    public static List<ImageVO> converter(List<Cover> covers) {
        return covers.stream().map(cover -> converter(cover)).collect(Collectors.toList());
    }
}
