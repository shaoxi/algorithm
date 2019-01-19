package com.shaoxi.algorithm.test.sort;

/**
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param a
     */
    public static void sort(int[] a){
        if(a==null){
            return;
        }
        for(int i=0; i<a.length-1; i++){
            //插入已排好序数组
            int j = i +1;
            int v = a[j];
            for(; j>0; j--){
                if(a[j-1]>v){
                    a[j] = a[j-1];
                }else{
                    break;
                }
            }
            a[j] = v;
        }
    }
}
