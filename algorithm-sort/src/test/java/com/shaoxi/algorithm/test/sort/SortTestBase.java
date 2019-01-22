package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.test.tool.Printer;
import com.shaoxi.algorithm.test.tool.SortTestData;
import org.junit.jupiter.api.Assertions;

import java.util.function.Function;

/**
 *
 * 基础排序测试类
 *
 * @author shaoxi.ycw
 * @since 2019-01-20
 */
public class SortTestBase {

    /**
     * 排序，默认打印详细日志
     * @param size 排序数据大小
     * @param sortFunc 排序函数
     * @return 耗时
     */
    public long sort(int size, Function<int[], Void> sortFunc) {
        return sort(size,sortFunc,true);
    }

    /**
     * 排序
     *
     * @param size 大小
     * @param sortFunc
     * @param printLog
     * @return
     */
    public long sort(int size, Function<int[], Void> sortFunc, boolean printLog){
        int[] testData = SortTestData.testData(size);
        return sort(testData, sortFunc, printLog);
    }

    /**
     *
     * @param testData
     * @param sortFunc
     * @param printLog
     * @return
     */
    public long sort(int[] testData, Function<int[], Void> sortFunc, boolean printLog){
        int[] expect = SortTestData.expectData(testData);
        if(printLog){
            Printer.print("sort\tinput", testData);
        }

        long start = System.currentTimeMillis();
        sortFunc.apply(testData);
        long useTime = System.currentTimeMillis() - start;

        if(printLog){
            Printer.print("sort\tresult", testData);
            Printer.print("expect\tresult", testData);
            System.out.println("run\ttime\t"+ useTime);
        }

        Assertions.assertArrayEquals(testData, expect, "sort result is incorrect!");
        return useTime;
    }
}
