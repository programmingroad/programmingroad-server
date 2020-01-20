package com.programmingroad.blog.service;

import com.programmingroad.blog.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 14:49
 * @description:
 * @version: 1.0
 **/
public interface ImageService {

    /**
     * 上传内容图片
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    ImageVO uploadContentImage(MultipartFile multipartFile) throws IOException;

    /**
     * 上传封面图片
     *
     * @param multipartFile
     * @throws IOException
     */
    void uploadCoverImage(MultipartFile multipartFile) throws IOException;

    /**
     * 获取封面图片
     *
     * @return
     */
    List<ImageVO> listCoverImages();

    /**
     * 删除封面图片
     *
     * @param id
     */
    void deleteCoverImage(Long id);
}
