/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.test.other;

import com.shaoxi.algorithm.common.tool.ArraysTool;
import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author shaoxi.ycw
 * @since 2019-01-27
 */
public class ArraysToolTest {

    @Test
    @DisplayName("最大最小值")
    void findMaxMinValue(){
        int[] a = TestData.testData(1000*10000);
        int exceptMin = test1("TestData::minValue", a, TestData::minValue);
        int exceptMax = test1("TestData::maxValue", a, TestData::maxValue);
        int max = test1("ArraysTool::findMaxValue", a, ArraysTool::findMaxValue);
        int min = test1("ArraysTool::findMinValue", a, ArraysTool::findMinValue);
        Assertions.assertEquals(exceptMin, min,"min result error");
        Assertions.assertEquals(exceptMax, max,"max result error");
    }

    private int test1(String name, int[] a, Function<int[], Integer> func){
        long start = System.currentTimeMillis();
        int r = func.apply(a);
        long end = System.currentTimeMillis();
        System.out.println(ZonedDateTime.now() + name+ " use time:"+ (end-start));
        return r;
    }
}