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

    private final String imagePrefix = "/api/image";

    @Override
    public ImageVO uploadImage(MultipartFile multipartFile) throws IOException {
        String imageUrl = Paths.get(this.imagePrefix, System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename()).toString();
        File destFile = Paths.get(this.staticLocation, imageUrl).toFile();
        FileUtils.writeByteArrayToFile(destFile, multipartFile.getBytes());
        return ImageVO.builder().url(imageUrl).build();
    }
}
