package com.shaoxi.algorithm.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-20
 */
class HeapSortTest extends SortTestBase {
    @Test
    @DisplayName("HeapSort_sort_C0001_堆排序_size_100")
    void sort(){
        sort(100, HeapSort::sort);
    }
}