package com.shaoxi.algorithm.common.tool;

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
        return a==null || a.length==0;
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

    /**
     * 交互两个i和j两个元素位置
     *
     * @param a
     * @param i
     * @param j
     * @return
     */
    public static void exchange(int[] a, int i, int j){
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }
}

