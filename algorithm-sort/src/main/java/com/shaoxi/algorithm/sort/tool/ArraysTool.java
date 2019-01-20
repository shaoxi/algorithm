package com.shaoxi.algorithm.sort.tool;

/**
 *
 * 数组工具
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class ArraysTool {

    /**
     * 判断数组是否为空
     *
     * @param a
     * @return
     */
    public static boolean isEmpty(int[] a){
        if(a==null || a.length==0){
            return true;
        }
        return false;
    }

    /**
     * 拷贝数组
     *
     * @param src
     * @param start
     * @param length
     * @return
     */
    public static int[] copy(int[] src, int start, int length){
        int[] dest = new int[length];
        System.arraycopy(src, start, dest, 0, length);
        return dest;
    }
}

