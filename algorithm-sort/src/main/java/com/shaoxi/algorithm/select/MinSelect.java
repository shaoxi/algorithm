package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 最小值查找
 *
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class MinSelect {
    /**
     * 查找数组最小值
     *
     * @param a 数组
     * @return 最小值
     */
    public static int select(int[] a) {
        if (ArraysTool.isEmpty(a)) {
            return 0;
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min>a[i]){
                min = a[i];
            }
        }

        return min;
    }

}
