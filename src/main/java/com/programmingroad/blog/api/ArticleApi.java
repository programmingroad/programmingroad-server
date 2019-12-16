package com.programmingroad.blog.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.programmingroad.blog.enums.ReleasedEnum;
import com.programmingroad.blog.service.ArticleService;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ArticleVO;
import com.programmingroad.blog.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/12/3 13:47
 * @description:
 * @version: 1.0
 **/

@Api(tags = "ArticleApi")
@RestController
@RequestMapping(value = "/api/article")
@Slf4j
public class ArticleApi {

    @Autowired
    ArticleService articleService;

    @ApiOperation(value = "通过标签获取已发布文章列表")
    @GetMapping("/listPage")
    public ResultVO<List<ArticleVO>> getListPage(@ApiParam(value = "页码", required = true) @RequestParam("page") Integer page,
                                                 @ApiParam(value = "标签id", required = true) @RequestParam("tagId") Long tagId) {
        log.info("获取文章列表: page={}, tagId={};", page, tagId);
        IPage<ArticleVO> articleVOIPage = articleService.listPage(page, tagId, ReleasedEnum.RELEASED);
        return ResultUtil.ok(articleVOIPage);
    }

    @ApiOperation(value = "通过id获取文章")
    @GetMapping("/article/{id}")
    public ResultVO<ArticleVO> getContent(@ApiParam(value = "文章id", required = true) @PathVariable Long id) {
        log.info("获取文章: id={};", id);
        ArticleVO articleVO = articleService.get(id, ReleasedEnum.RELEASED);
        return ResultUtil.ok(articleVO);
    }

}
