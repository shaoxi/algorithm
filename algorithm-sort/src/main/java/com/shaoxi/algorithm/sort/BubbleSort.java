package com.shaoxi.algorithm.sort;


import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 冒泡排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class BubbleSort {

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
        for(int i=0; i<a.length-1;i++){
            for(int j=a.length-1; j>0; j--){
                if(a[j]<a[j-1]){
                    exchange(a, j, j-1);
                }
            }
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int v = a[i];
        a[i] = a[j];
        a[j] = v;
    }
}
