package com.shaoxi.algorithm.test.sort;

import com.shaoxi.algorithm.test.tool.Printer;
import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;

import java.util.function.Consumer;

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
    public long sort(int size, Consumer<int[]> sortFunc) {
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
    public long sort(int size, Consumer<int[]> sortFunc, boolean printLog){
        int[] testData = TestData.testData(size);
        return sort(testData, sortFunc, printLog, true);
    }

    /**
     *
     * @param testData
     * @param sortFunc
     * @param printLog
     * @return
     */
    public long sort(int[] testData, Consumer<int[]> sortFunc, boolean printLog, boolean checkResult){
        int[] expect = TestData.expectData(testData);
        if(printLog){
            Printer.print("sort\tinput", testData);
        }

        long start = System.currentTimeMillis();
        sortFunc.accept(testData);
        long useTime = System.currentTimeMillis() - start;

        if(printLog){
            Printer.print("sort\tresult", testData);
            Printer.print("expect\tresult", expect);
            System.out.println("run\ttime\t"+ useTime);
        }

        if(checkResult){
            Assertions.assertArrayEquals(testData, expect, "sort result is incorrect!");
        }
        return useTime;
    }
}
