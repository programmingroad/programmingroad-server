package com.programmingroad.blog.utils;

import java.util.Random;

/**
 * @author: baoqi.liu
 * @create: 2020/1/21 10:55
 * @description:
 * @version: 1.0
 **/
public class RandomUtil {

    private static Random random = new Random();

    /**
     * 获取指定范围的随机数
     *
     * @param bound
     * @return
     */
    public static Integer getRandom(Integer bound) {
        return random.nextInt(bound);
    }
}
