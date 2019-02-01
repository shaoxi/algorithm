/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shaoxi.ycw
 * @version $Id: StackPerformance.java, v 0.1 2019年02月01日 10:35 AM shaoxi.ycw Exp $
 */
public class StackPerformance extends StackTestBase<Integer> {

    @Test
    @DisplayName("栈性能比较测试")
    void testStack() {
        Map<String, PerformanceResult> resultMap = new TreeMap<>();
        int count = 20;
        int size = 100 * 10000;
        for (int i = 0; i < count; i++) {
            testPushAndPop(resultMap, "1 ArrayStack初始容量16", TestData.testDataSortedList(size), new ArrayStack<>());
            testPushAndPop(resultMap, "2 ArrayStack初始容量1000000", TestData.testDataSortedList(size), new ArrayStack<>(size));
            testPushAndPop(resultMap, "3 ArrayStack固定容量1000000", TestData.testDataSortedList(size), new ArrayStack<>(size, true));
            testPushAndPop(resultMap, "4 LinkedStack容量不定", TestData.testDataSortedList(size), new LinkedStack<>());
        }
        System.out.println("==================");
        for(Map.Entry<String, PerformanceResult> entry:resultMap.entrySet()){
            long pushAvg = entry.getValue().pushUseTime/count;
            long popAvg = entry.getValue().popUseTime/count;
            long totalAvg = entry.getValue().totalUseTime/count;
            System.out.println(String.format("%s pushAvg=%d popAvg=%d totalAvg=%d", entry.getKey(), pushAvg, popAvg, totalAvg));
        }
    }

    private void testPushAndPop(Map<String, PerformanceResult> resultMap, String title, List<Integer> testData, IStack<Integer> stack) {
        System.out.println(title);
        PerformanceResult performanceResult = test(testData, stack, false);

        if(resultMap.get(title)!=null){
            resultMap.get(title).add(performanceResult);
        }else{
            resultMap.put(title, performanceResult);
        }
    }
}