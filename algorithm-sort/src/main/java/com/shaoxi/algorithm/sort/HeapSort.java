package com.shaoxi.algorithm.sort;

import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 堆排序
 *
 * @author shaoxi.ycw
 * @sine 2019-01-24
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        if(ArraysTool.isEmpty(a)){
            return ;
        }
        buildHeap(a, a.length);
        for(int i=a.length - 1; i>0; i--){
            ArraysTool.exchange(a, 0, i);
            heapify(a, 0 , i);
        }
    }

    /**
     * 构建堆，子叶子节点开始，自底向上构建
     * @param a
     */
    private static void buildHeap(int[] a, int heapSize){
        for(int i=parent(heapSize-1);i>=0;i--){
            heapify(a , i, heapSize);
        }
    }

    /**
     * 堆性质维护，大顶堆
     *
     * @param a
     * @param i
     */
    private static void heapify(int[] a, int i, int heapSize){
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if(left<heapSize && a[largest]<a[left]){
            largest = left;
        }

        if(right<heapSize && a[largest]<a[right]){
            largest = right;
        }

        if(largest != i){
            ArraysTool.exchange(a, i, largest);
            heapify(a, largest, heapSize);
        }
    }

    /**
     * 父节点
     *
     * @param i
     * @return
     */
    private static int parent(int i){
        return i >> 1 ;
    }

    /**
     * 左孩子
     *
     * @param i
     * @return
     */
    private static int leftChild(int i){
        return i << 1;
    }

    /**
     * 右孩子
     *
     * @param i
     * @return
     */
    private static int rightChild(int i){
        return (i << 1) + 1;
    }
}
