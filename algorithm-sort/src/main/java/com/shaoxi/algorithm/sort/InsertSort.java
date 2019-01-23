package com.shaoxi.algorithm.sort;


import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 *
 * 插入排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param a
     */
    public static Void sort(int[] a){
        if(ArraysTool.isEmpty(a)){
            return null;
        }
        for(int i=1; i<a.length; i++){
            //将a[i]插入已排序数组a[i-1]
            int key = a[i];
            int j = i - 1;
            for(; j>=0;j--){
                if(a[j]>key){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = key;
        }
        return null;
    }
}
