/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shaoxi.ycw
 * @version $Id: StackPerformance.java, v 0.1 2019年02月01日 10:35 AM shaoxi.ycw Exp $
 */
public class QueuePerformance extends QueueTestBase<Integer> {

    @Test
    @DisplayName("队列性能比较测试")
    void testStack() {
        Map<String, PerformanceResult> resultMap = new TreeMap<>();
        int count = 10;
        int size = 100 * 10000;
        List<Integer> testData = TestData.testDataSortedList(size);
        for (int i = 0; i < count; i++) {
            testQueue(resultMap, "1 ArrayQueue", testData, new ArrayQueue<>(size));
            testQueue(resultMap, "2 LinkedQueue", testData, new LinkedQueue<>());
        }
        System.out.println("==================");
        for (Map.Entry<String, PerformanceResult> entry : resultMap.entrySet()) {
            long enqueueAvg = entry.getValue().enqueueUseTime / count;
            long dequeueAvg = entry.getValue().dequeueUseTime / count;
            long totalAvg = entry.getValue().totalUseTime / count;
            System.out.println(String.format("%s pushAvg=%d popAvg=%d totalAvg=%d", entry.getKey(), enqueueAvg, dequeueAvg, totalAvg));
        }
    }

    private void testQueue(Map<String, PerformanceResult> resultMap, String title, List<Integer> testData, IQueue<Integer> stack) {
        System.out.println(title);
        PerformanceResult performanceResult = test(testData, stack, false);

        if (resultMap.get(title) != null) {
            resultMap.get(title).add(performanceResult);
        } else {
            resultMap.put(title, performanceResult);
        }
    }
}