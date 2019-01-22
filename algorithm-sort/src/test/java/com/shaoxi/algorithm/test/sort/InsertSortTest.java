package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.sort.InsertSort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class InsertSortTest extends SortTestBase {

    @Test
    @DisplayName("InsertionSort_sort_C0001_插入排序_size_100")
    void sort(){
        sort(100, InsertSort::sort);
    }

}
