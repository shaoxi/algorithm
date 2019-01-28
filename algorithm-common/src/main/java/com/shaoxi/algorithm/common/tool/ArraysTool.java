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

    /**
     * 返回数组的最大值
     *
     * @param a
     * @return
     */
    public static int findMaxValue(int[] a){
        if(isEmpty(a)){
            return 0;
        }
        return findMaxValue0(a, 0, a.length-1);
    }

    private static int findMaxValue0(int[] a, int p, int q){
        if(p<q){
            int r = (p+q)/2;
            int left = findMaxValue0(a, p, r);
            int right = findMaxValue0(a, r+1, q);
            return Integer.max(left, right);
        }else{
            return a[p];
        }
    }


    /**
     * 返回数组的最小值
     *
     * @param a
     * @return
     */
    public static int findMinValue(int[] a){
        if(isEmpty(a)){
            return 0;
        }
        return findMinValue0(a, 0, a.length-1);
    }

    private static int findMinValue0(int[] a, int p, int q){
        if(p<q){
            int r = (p+q)/2;
            int left = findMinValue0(a, p, r);
            int right = findMinValue0(a, r+1, q);
            return Integer.min(left, right);
        }else{
            return a[p];
        }
    }
}

