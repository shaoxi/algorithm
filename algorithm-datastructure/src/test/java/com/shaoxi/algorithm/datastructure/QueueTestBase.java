/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi.ycw
 * @version $Id: QueueTestBase.java, v 0.1 2019年02月01日 4:08 PM shaoxi.ycw Exp $
 */
public class QueueTestBase<E> {

    /**
     * @param testData
     * @param queue
     * @param isPrintLog
     * @return
     */
    public PerformanceResult test(List<E> testData, IQueue<E> queue, boolean isPrintLog) {
        return test(testData, queue, isPrintLog, true);
    }

    /**
     * @param testData
     * @param queue
     * @param isPrintLog
     * @param isCheckResult
     * @return
     */
    public PerformanceResult test(List<E> testData, IQueue<E> queue, boolean isPrintLog, boolean isCheckResult) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < testData.size(); i++) {
            queue.enqueue(testData.get(i));
        }
        long pushUseTime = System.currentTimeMillis() - start;
        List<E> result = new ArrayList<>();
        if (isCheckResult) {
            while (!queue.isEmpty()) {
                result.add(queue.dequeue());
            }
        } else {
            while (!queue.isEmpty()) {
                queue.dequeue();
            }
        }

        long pushAndPopUseTime = System.currentTimeMillis() - start;
        long popUseTime = pushAndPopUseTime - pushUseTime;

        if (isPrintLog) {
            System.out.println("expect\t" + testData);
            System.out.println("result\t" + result);
        }

        PerformanceResult performanceResult = new PerformanceResult(pushUseTime, popUseTime, pushAndPopUseTime);

        System.out.println(String.format("%s.use\t", queue.getClass().getSimpleName()) + performanceResult);

        if (isCheckResult) {
            Assertions.assertArrayEquals(testData.toArray(), result.toArray());
        }

        return performanceResult;
    }

    class PerformanceResult {
        /**
         * 入队耗时
         */
        public long enqueueUseTime;
        /**
         * 出队耗时
         */
        public long dequeueUseTime;
        /**
         * 总耗时
         */
        public long totalUseTime;

        public PerformanceResult() {
        }

        public PerformanceResult(long enqueueUseTime, long dequeueUseTime, long totalUseTime) {
            this.enqueueUseTime = enqueueUseTime;
            this.dequeueUseTime = dequeueUseTime;
            this.totalUseTime = totalUseTime;
        }

        public void add(PerformanceResult performanceResult) {
            this.enqueueUseTime += performanceResult.enqueueUseTime;
            this.dequeueUseTime += performanceResult.dequeueUseTime;
            this.totalUseTime += performanceResult.totalUseTime;
        }

        @Override
        public String toString() {
            return "PerformanceResult{" +
                    "enqueueUseTime=" + enqueueUseTime +
                    ", dequeueUseTime=" + dequeueUseTime +
                    ", totalUseTime=" + totalUseTime +
                    '}';
        }
    }
}