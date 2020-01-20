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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @ApiOperation(value = "上传内容图片")
    @PostMapping("/content/upload")
    public ResultVO<ImageVO> uploadContentImage(@ApiParam(value = "上传的图片", required = true) MultipartFile multipartFile) throws IOException {
        log.info("上传图片: name={}, type={}, size={};", multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        ImageVO imageVO = imageService.uploadContentImage(multipartFile);
        return ResultUtil.ok(imageVO);
    }

    @ApiOperation(value = "上传封面图片")
    @PostMapping("/cover/upload")
    public ResultVO uploadCoverImage(@ApiParam(value = "上传的图片", required = true) MultipartFile multipartFile) throws IOException {
        log.info("上传图片: name={}, type={}, size={};", multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getSize());
        imageService.uploadCoverImage(multipartFile);
        return ResultUtil.ok();
    }

    @ApiOperation(value = "获取封面图片列表")
    @GetMapping("/cover/list")
    public ResultVO<List<ImageVO>> listCoverImages() {
        List<ImageVO> coverImages = imageService.listCoverImages();
        return ResultUtil.ok(coverImages);
    }

    @ApiOperation(value = "删除封面图片")
    @DeleteMapping("/cover/{id}")
    public ResultVO deleteCoverImage(@ApiParam(value = "标签id", required = true) @PathVariable Long id) {
        imageService.deleteCoverImage(id);
        return ResultUtil.ok();
    }
}
