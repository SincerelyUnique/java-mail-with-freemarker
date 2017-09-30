/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.util;

/**
 * <p>
 * <code>StringHelper</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2017/9/29 15:00
 */
public class StringHelper {

    /**
     * 拆分字符串
     * @param resource 目标文件
     * @param tr 拆分字符
     * @return 结果数组
     */
    public static String[] split(String resource, String tr) {
        String[] array = resource.split(tr);
        return array;
    }
}
