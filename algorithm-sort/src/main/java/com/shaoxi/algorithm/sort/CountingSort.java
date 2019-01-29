package com.shaoxi.algorithm.sort;


import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 计数排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class CountingSort {

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    public static void sort(int[] a){
        if(ArraysTool.isEmpty(a)){
            return ;
        }

        //最大，最小值
        int min = a[0];
        int max = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i] < min){
                min = a[i];
            }
            if(a[i] > max){
                max = a[i];
            }
        }

        int[] b = new int[a.length];
        int[] c = new int[max-min+1];
        int offset = 0 - min;
        //初始化c
        for(int i=0; i<c.length; i++){
            c[i] = 0;
        }

        //计数，每个数字出现的次数
        for(int i=0;i<a.length;i++){
            c[a[i]+offset] = c[a[i]+offset] + 1;
        }

        //统计
        for(int i=1; i< c.length; i++){
            c[i] = c[i]+c[i-1];
        }

        //排序b
        for(int i=0; i< a.length; i++){
            b[c[a[i]+offset] -1 ] = a[i];
            c[a[i]+offset] = c[a[i]+offset] -1;
        }

        //复制会a
        System.arraycopy(b,0,a,0,b.length);
    }

    private static void exchange(int[] a, int i, int j) {
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }
}
