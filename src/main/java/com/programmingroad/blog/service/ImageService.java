package com.programmingroad.blog.service;

import com.programmingroad.blog.vo.ImageVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 14:49
 * @description:
 * @version: 1.0
 **/
public interface ImageService {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    ImageVO uploadImage(MultipartFile multipartFile) throws IOException;
}
