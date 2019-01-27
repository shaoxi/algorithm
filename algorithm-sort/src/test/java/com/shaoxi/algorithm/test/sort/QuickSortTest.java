package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.sort.QuickSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shaoxi.ycw
 * @since 2019-01-27
 */
class QuickSortTest extends SortTestBase {

    @Test
    @DisplayName("QuickSort_sort_C0001_快速排序_size_100")
    void sort() {
        sort(100, QuickSort::sort);
    }


    @Test
    @DisplayName("QuickSort_randomSort_C0001_快速排序_size_100")
    void randomSort() {
        sort(100, QuickSort::randomSort);
    }
}