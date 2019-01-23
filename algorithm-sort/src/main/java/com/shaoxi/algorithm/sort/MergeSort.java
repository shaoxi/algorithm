package com.shaoxi.algorithm.sort;


import com.shaoxi.algorithm.common.tool.ArraysTool;

/**
 * 归并排序
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * @param a
     */
    public static Void sort(int[] a){
        if(ArraysTool.isEmpty(a)){
            return null;
        }
        mergeSort(a, 0, a.length-1);
        return null;
    }

    private static void mergeSort(int[] a, int p, int q){
        int r = (p + q)/2;
        if(p<r){
            mergeSort(a, p, r);
            mergeSort(a, r+1, q);
        }
        merge(a, p, r, q);
    }


    /**
     * 合并两个已排序数组，p≤q<r 其中a[p..q] 和 a[q+1..r] 已排序。将a[p..q]和a[q+1..r]合并到a[q..r]
     *
     * @param a 数组
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r){
        //新开两个数组，分别存储a[p..q]和[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, p, L, 0, n1);
        System.arraycopy(a, q+1, R, 0, n2);

        int j=0;
        int k=0;
        for(int i=p; p<=r; i++){
            if (j<n1 && k<n2){
                // 两个都没取完
                if(L[j]>R[k]){
                    a[i] = R[k];
                    k++;
                }else{
                    a[i] = L[j];
                    j++;
                }
            }else{
                if(j<n1){
                    System.arraycopy(L, j, a, i, n1-j);
                }else if(k<n2){
                    System.arraycopy(R, k, a, i, n2-k);
                }
                break;
            }
        }
    }
}
