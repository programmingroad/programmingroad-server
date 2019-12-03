package com.programmingroad.blog.api.admin;

import com.programmingroad.blog.service.TagService;
import com.programmingroad.blog.utils.ResultUtil;
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
 * @create: 2019/11/21 15:45
 * @description:
 * @version: 1.0
 **/

@Api(tags = "AdminTagApi")
@RestController
@RequestMapping(value = "/api/admin/tag")
@Slf4j
public class AdminTagApi {

    @Autowired
    TagService tagService;

    @ApiOperation(value = "获取所有标签")
    @GetMapping("/all")
    public ResultVO<TagVO> getAll() {

        log.info("【Tag】获取所有标签");

        List<TagVO> tagVOS = tagService.list();

        return ResultUtil.success(tagVOS);
    }

    @ApiOperation(value = "添加标签")
    @PutMapping("/add")
    public ResultVO<TagVO> add(@ApiParam(value = "标签名称", required = true) @RequestParam("name") String name) {

        log.info("【Tag】添加标签: name={};", name);

        tagService.add(name);

        return ResultUtil.success(null);
    }

    @ApiOperation(value = "删除标签")
    @DeleteMapping("/delete/{id}")
    public ResultVO<TagVO> delete(@ApiParam(value = "标签id", required = true) @PathVariable Long id) {

        log.info("【Tag】删除标签: id={};", id);

        tagService.delete(id);

        return ResultUtil.success(null);
    }
}
