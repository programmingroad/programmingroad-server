package com.programmingroad.blog.api;

import com.programmingroad.blog.service.TagService;
import com.programmingroad.blog.utils.ResultUtil;
import com.programmingroad.blog.vo.ResultVO;
import com.programmingroad.blog.vo.TagVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author: baoqi.liu
 * @create: 2019/12/3 13:47
 * @description:
 * @version: 1.0
 **/

@Api(tags = "TagApi")
@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagApi {

    @Autowired
    TagService tagService;

    @ApiOperation(value = "获取所有标签")
    @GetMapping("/all")
    public ResultVO<List<TagVO>> getAll() {
        log.info("获取所有标签");
        List<TagVO> tagVOS = tagService.list();
        // 按照 create_time 升序排列
        Collections.reverse(tagVOS);
        return ResultUtil.ok(tagVOS);
    }
}
