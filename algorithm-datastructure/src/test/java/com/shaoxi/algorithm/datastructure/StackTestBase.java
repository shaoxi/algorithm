/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈测试基类
 *
 * @author shaoxi.ycw
 * @version $Id: StackTestBase.java, v 0.1 2019年02月01日 10:12 AM shaoxi.ycw Exp $
 */
public class StackTestBase<E> {

    /**
     * 测试
     *
     * @param testData
     * @param stack
     * @param isPrintLog
     * @return 运行耗时
     */
    PerformanceResult test(List<E> testData, IStack<E> stack, boolean isPrintLog) {
        return test(testData, stack, isPrintLog, true);
    }

    /**
     * 测试
     *
     * @param testData
     * @param stack
     * @param isPrintLog
     * @param isCheckResult
     * @return 运行耗时
     */
    PerformanceResult test(List<E> testData, IStack<E> stack, boolean isPrintLog, boolean isCheckResult) {
        long start = System.currentTimeMillis();
        for (int i = testData.size() - 1; i >= 0; i--) {
            stack.push(testData.get(i));
        }
        long pushUseTime = System.currentTimeMillis() - start;
        List<E> result = new ArrayList<>();
        if (isCheckResult) {
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        } else {
            while (!stack.isEmpty()) {
                stack.pop();
            }
        }

        long pushAndPopUseTime = System.currentTimeMillis() - start;
        long popUseTime = pushAndPopUseTime - pushUseTime;

        if (isPrintLog) {
            System.out.println("expect\t" + testData);
            System.out.println("result\t" + result);
        }

        PerformanceResult performanceResult = new PerformanceResult(pushUseTime, popUseTime, pushAndPopUseTime);

        System.out.println(String.format("%s.use\t", stack.getClass().getSimpleName()) + performanceResult);

        if (isCheckResult) {
            Assertions.assertArrayEquals(testData.toArray(), result.toArray());
        }

        return performanceResult;
    }

    class PerformanceResult {
        /**
         * 入栈耗时
         */
        public long pushUseTime;
        /**
         * 出栈耗时
         */
        public long popUseTime;
        /**
         * 总耗时
         */
        public long totalUseTime;

        public PerformanceResult() {
        }

        public PerformanceResult(long pushUseTime, long popUseTime, long totalUseTime) {
            this.pushUseTime = pushUseTime;
            this.popUseTime = popUseTime;
            this.totalUseTime = totalUseTime;
        }

        public void add(PerformanceResult performanceResult) {
            this.pushUseTime += performanceResult.pushUseTime;
            this.popUseTime += performanceResult.popUseTime;
            this.totalUseTime += performanceResult.totalUseTime;
        }

        @Override
        public String toString() {
            return "PerformanceResult{" +
                    "pushUseTime=" + pushUseTime +
                    ", popUseTime=" + popUseTime +
                    ", totalUseTime=" + totalUseTime +
                    '}';
        }
    }
}