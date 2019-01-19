package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.test.tool.Printer;
import com.shaoxi.algorithm.test.tool.SortTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-19
 */
public class InsertionSortTest {

    @Test
    @DisplayName("InsertionSort_sort_C0001_插入排序_数组大小100_结果正确")
    void testSort(){
        int size = 100;
        int[] testData = SortTestData.testData(size);
        System.out.print("before sort:");
        Printer.print(testData);
        long start = System.currentTimeMillis();
        InsertionSort.sort(testData);
        System.out.print("after sort :");
        Printer.print(testData);
        System.out.println("run time:"+ (System.currentTimeMillis() - start));

        Assertions.assertArrayEquals(testData, SortTestData.expectData(testData), "sort result is incorrect!");
    }

}
