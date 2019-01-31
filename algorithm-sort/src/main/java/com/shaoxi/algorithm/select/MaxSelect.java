package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 最大值查找
 *
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class MaxSelect {
    /**
     * 查找数组最大值
     *
     * @param a 数组
     * @return 最大值
     */
    public static int select(int[] a) {
        if (ArraysTool.isEmpty(a)) {
            return 0;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max<a[i]){
                max = a[i];
            }
        }

        return max;
    }

}
