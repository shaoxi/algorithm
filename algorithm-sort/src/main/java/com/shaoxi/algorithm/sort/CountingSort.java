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
