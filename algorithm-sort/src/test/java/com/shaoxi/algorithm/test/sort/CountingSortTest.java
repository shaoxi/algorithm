package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.sort.BubbleSort;
import com.shaoxi.algorithm.sort.CountingSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-20
 */
class CountingSortTest extends SortTestBase {
    @Test
    @DisplayName("CountingSort_sort_C0001_计数排序_size_100")
    void sort(){
        sort(100, CountingSort::sort);
    }
}