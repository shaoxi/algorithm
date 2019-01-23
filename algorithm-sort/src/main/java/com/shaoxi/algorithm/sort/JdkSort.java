package com.shaoxi.algorithm.sort;


import com.shaoxi.algorithm.common.tool.ArraysTool;

import java.util.Arrays;

/**
 * jdk 排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class JdkSort {
    /**
     * 使用jdk提供的排序算法排序
     *
     * @param a
     * @return
     */
    public static Void sort(int[] a){
        if(ArraysTool.isEmpty(a)){
            return null;
        }
        Arrays.sort(a);
        return null;
    }
}
