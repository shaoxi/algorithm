package com.shaoxi.algorithm.sort;

import com.shaoxi.algorithm.common.tool.ArraysTool;

import java.util.Random;

/**
 *
 * 快速排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-27
 */
public class QuickSort {
    /**
     * 快速排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 快排随机化版本，主元随机选择
     *
     * @param a
     */
    public static void randomSort(int[] a){
        Random random = new Random();
        randomQuickSort(a, 0, a.length - 1, random);
    }

    /**
     * 快排随机化版本，主元随机选择
     *
     * @param a
     * @param p
     * @param q
     */
    private static void randomQuickSort(int[] a, int p, int q, Random random){
        if(p<q){
            int r = randomPartition(a, p, q, random);
            randomQuickSort(a, p, r - 1, random);
            randomQuickSort(a, r+1, q, random);
        }
    }

    /**
     * 随机选取一个主元，分割数组
     *
     * @param a
     * @param p
     * @param q
     * @param random
     * @return
     */
    private static int randomPartition(int[] a, int p, int q, Random random) {
        int r = random.nextInt( q - p + 1) + p;
        ArraysTool.exchange(a, r, q);
        return partition(a, p, q);
    }

    /**
     * 快排
     *
     * @param a 数组
     * @param p 数组开始下标
     * @param q 数组结束下标
     */
    private static void quickSort(int[] a, int p, int q){
        if(p<q){
            int r = partition(a, p, q);
            quickSort(a, p, r - 1);
            quickSort(a, r+1, q);
        }
    }

    /**
     * 分割数组为两部分，使得主元左边的数组元素都小于等于主元，主元右边的数组元素都大于等于主元。
     *
     * @param a 数组
     * @param p 数组开始下标
     * @param q 数组结束下标
     * @return 主元位置
     */
    private static int partition(int[] a, int p, int q){
        int x = a[q];
        int j = p ;
        for(int i=p; i<q; i++){
            if(a[i] < x ){
                ArraysTool.exchange(a, i, j);
                j++;
            }
        }

        ArraysTool.exchange(a, j, q);

        return j;
    }
}