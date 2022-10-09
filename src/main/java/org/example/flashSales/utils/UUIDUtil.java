package org.example.flashSales.utils;

import java.util.UUID;

/**
 * @description: 生成UUID的工具类
 */
public class UUIDUtil {

    /**
     * 产生UUID字符串，将“-”去除
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}