package com.programmingroad.blog.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.programmingroad.blog.enums.DeletedEnum;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: baoqi.liu
 * @create: 2019/11/26 18:49
 * @description:
 * @version: 1.0
 **/

@Data
public class Article {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private DeletedEnum deleted;
}
