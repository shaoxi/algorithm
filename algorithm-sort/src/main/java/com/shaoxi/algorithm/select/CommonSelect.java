package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.common.tool.ArraysTool;

import java.util.Random;

/**
 * 查找第i小的元素
 *
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class CommonSelect {
    /**
     * 查找数组最大值
     *
     * @param a 数组
     * @param i 第i小
     * @return 第i小的值
     */
    public static int select(int[] a, int i) {
        if (ArraysTool.isEmpty(a) || i<=0 || i>a.length) {
            return 0;
        }
        return randomSelect(a, 0, a.length - 1, i, new Random());
    }

    private static int randomSelect(int[] a, int p, int q, int i, Random random) {
        if (p == q) {
            return a[p];
        }

        int r = randomPartition(a, p, q, random);
        int k = r - p + 1;
        if (i == k) {
            return a[r];
        } else if (i < k) {
            return randomSelect(a, p, r - 1, i, random);
        } else {
            return randomSelect(a, r + 1, q, i - k , random);
        }
    }

    private static int randomPartition(int[] a, int p, int q, Random random) {
        int j = random.nextInt(q - p + 1);
        ArraysTool.exchange(a, p + j, q);
        return partition(a, p, q);
    }

    /**
     * 分割数组，使得数组左边小于 pivot, 数组右边都大于等于pivot
     *
     * @param a 数组
     * @param p 开始下标
     * @param q 结束下标
     * @return 数组分割位置
     */
    private static int partition(int[] a, int p, int q) {
        int pivot = a[q];
        int j = p;
        for (int i = p; i <= q; i++) {
            if (a[i] < pivot) {
                ArraysTool.exchange(a, i, j);
                j++;
            }
        }

        ArraysTool.exchange(a, j, q);
        return j;
    }
}
