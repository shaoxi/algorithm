package com.shaoxi.algorithm.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-20
 */
class BubbleSortTest extends SortTestBase {
    @Test
    @DisplayName("BubbleSort_sort_C0001_冒泡排序_size_100")
    void sort(){
        sort(10, BubbleSort::sort);
    }
}