package com.programmingroad.blog.api.admin;

import com.programmingroad.blog.service.ImageService;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ImageVO;
import com.programmingroad.blog.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: baoqi.liu
 * @create: 2019/12/16 14:47
 * @description:
 * @version: 1.0
 **/

@Api(tags = "AdminImageApi")
@RestController
@RequestMapping(value = "/api/admin/image")
@Slf4j
public class AdminImageApi {

    @Autowired
    private ImageService imageService;

    @ApiOperation(value = "上传图片")
    @PostMapping("/upload")
    public ResultVO<ImageVO> uploadImage(@ApiParam(value = "上传的图片", required = true) MultipartFile multipartFile) throws IOException {
        log.info("上传图片: name={}, type={}, size={};", multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        ImageVO imageVO = imageService.uploadImage(multipartFile);
        return ResultUtil.ok(imageVO);
    }
}
