package com.programmingroad.blog.service.impl;

import com.programmingroad.blog.service.ImageService;
import com.programmingroad.blog.vo.ImageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 16:07
 * @description:
 * @version: 1.0
 **/

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Value("${blog.static-locations}")
    private String staticLocation;

    @Override
    public ImageVO uploadImage(MultipartFile multipartFile) throws IOException {
        File destFile = Paths.get(this.staticLocation, System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename()).toFile();
        multipartFile.transferTo(destFile);
        return ImageVO.builder().url(destFile.getName()).build();
    }
}
