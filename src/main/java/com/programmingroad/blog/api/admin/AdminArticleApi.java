package com.programmingroad.blog.api.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.programmingroad.blog.dto.ArticleDTO;
import com.programmingroad.blog.service.ArticleService;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ArticleVO;
import com.programmingroad.blog.vo.ResultVO;
import com.programmingroad.blog.vo.TagVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:53
 * @description:
 * @version: 1.0
 **/

@Api(tags = "AdminArticleApi")
@RestController
@RequestMapping(value = "/api/admin/article")
@Slf4j
public class AdminArticleApi {

    @Autowired
    ArticleService articleService;

    @ApiOperation(value = "文章列表")
    @GetMapping("/listPage")
    public ResultVO<List<ArticleVO>> getListPage(@ApiParam(value = "页码", required = true) @RequestParam("page") Integer page) {

        log.info("【Article】获取文章列表");

        IPage<ArticleVO> articleVOIPage = articleService.listPage(page, null, null);

        return ResultUtil.success(articleVOIPage);
    }

    @ApiOperation(value = "添加文章")
    @PutMapping("/add")
    public ResultVO add(@RequestBody ArticleDTO articleDTO) {

        log.info("【Article】添加文章: articleDTO={};", articleDTO);

        articleService.add(articleDTO);

        return ResultUtil.success(null);
    }

    @ApiOperation(value = "删除文章")
    @DeleteMapping("/delete/{id}")
    public ResultVO delete(@ApiParam(value = "文章id", required = true) @PathVariable Long id) {

        log.info("【Article】删除标签: id={};", id);

        articleService.delete(id);

        return ResultUtil.success(null);
    }

    @ApiOperation(value = "更新文章")
    @PatchMapping("/update/{id}")
    public ResultVO update(@ApiParam(value = "文章id", required = true) @PathVariable Long id, @RequestBody ArticleDTO articleDTO) {

        articleService.update(id, articleDTO);

        return ResultUtil.success(null);
    }
}
