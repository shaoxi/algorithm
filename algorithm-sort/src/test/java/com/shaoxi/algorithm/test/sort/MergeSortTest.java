package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.sort.MergeSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 *  归并排序测试
 *
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
class MergeSortTest extends SortTestBase {

    @Test
    @DisplayName("InsertionSort_sort_C0001_归并排序_size_100")
    void sort() {
       sort(100, MergeSort::sort);
    }
}