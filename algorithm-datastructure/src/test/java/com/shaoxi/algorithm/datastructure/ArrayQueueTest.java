/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author shaoxi.ycw
 * @version $Id: ArrayQueueTest.java, v 0.1 2019年02月01日 2:56 PM shaoxi.ycw Exp $
 */
public class ArrayQueueTest extends QueueTestBase<Integer> {
    @Test
    @DisplayName("ArrayQueue_有界队列_100_正常")
    void testNormal() {
        List<Integer> testData = TestData.testDataSortedList(100);
        test(testData, new ArrayQueue<>(testData.size()), true);
    }

    @Test
    @DisplayName("ArrayQueue_有界队列_队列溢出_QueueOverflowException")
    void testQueueOverflowException() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(1);
        Assertions.assertThrows(QueueOverflowException.class, () -> {
            arrayQueue.enqueue(1);
            arrayQueue.enqueue(2);
        });
    }

    @Test
    @DisplayName("ArrayQueue_有界队列_队列溢出_QueueUnderflowException")
    void testQueueUnderflowException() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(1);
        Assertions.assertThrows(QueueUnderflowException.class, () -> {
            arrayQueue.enqueue(1);
            arrayQueue.dequeue();
            arrayQueue.dequeue();
        });
    }
}