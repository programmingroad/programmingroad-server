package com.programmingroad.blog.service.impl;

import com.programmingroad.blog.converter.Cover2ImageVOConverter;
import com.programmingroad.blog.domain.Cover;
import com.programmingroad.blog.mapper.CoverMapper;
import com.programmingroad.blog.service.ImageService;
import com.programmingroad.blog.vo.ImageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

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

    @Value("${blog.content-image-prefix}")
    private String contentImagePrefix;

    @Value("${blog.cover-image-prefix}")
    private String coverImagePrefix;

    @Autowired
    private CoverMapper coverMapper;

    @Override
    public ImageVO uploadContentImage(MultipartFile multipartFile) throws IOException {
        String imageUrl = Paths.get(this.contentImagePrefix, System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename()).toString();
        File destFile = Paths.get(this.staticLocation, imageUrl).toFile();
        FileUtils.writeByteArrayToFile(destFile, multipartFile.getBytes());
        return ImageVO.builder().url(imageUrl).build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "image", key = "'cover'")
    public void uploadCoverImage(MultipartFile multipartFile) throws IOException {
        String imageUrl = Paths.get(this.coverImagePrefix, System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename()).toString();
        Cover cover = Cover.builder()
                .url(imageUrl)
                .build();
        coverMapper.insert(cover);
        File destFile = Paths.get(this.staticLocation, imageUrl).toFile();
        FileUtils.writeByteArrayToFile(destFile, multipartFile.getBytes());
    }

    @Override
    @Cacheable(value = "image", key = "'cover'")
    public List<ImageVO> listCoverImages() {
        List<Cover> covers = coverMapper.selectList(null);
        return Cover2ImageVOConverter.converter(covers);
    }

    @Override
    @CacheEvict(value = "image", key = "'cover'")
    public void deleteCoverImage(Long id) {
        coverMapper.deleteById(id);
    }
}
