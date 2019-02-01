/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxi.ycw
 * @version $Id: ArrayQueueTest.java, v 0.1 2019年02月01日 2:56 PM shaoxi.ycw Exp $
 */
public class ArrayQueueTest {
    @Test
    @DisplayName("有界队列_100_正常")
    void testNormal() {
        List<Integer> testData = TestData.testDataSortedList(100);
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(testData.size());
        List<Integer> result = execute(arrayQueue, testData);

        System.out.println("expect\t" + testData);
        System.out.println("result\t" + result);

        Assertions.assertArrayEquals(testData.toArray(), result.toArray());
    }

    @Test
    @DisplayName("有界队列_队列溢出_QueueOverflowException")
    void testQueueOverflowException() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(1);
        Assertions.assertThrows(QueueOverflowException.class, () -> {
            arrayQueue.enqueue(1);
            arrayQueue.enqueue(2);
        });
    }

    @Test
    @DisplayName("有界队列_队列溢出_QueueUnderflowException")
    void testQueueUnderflowException() {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(1);
        Assertions.assertThrows(QueueUnderflowException.class, () -> {
            arrayQueue.enqueue(1);
            arrayQueue.dequeue();
            arrayQueue.dequeue();
        });
    }

    public List<Integer> execute(IQueue<Integer> queue, List<Integer> testData) {
        for (Integer v : testData) {
            queue.enqueue(v);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer v = queue.dequeue();
            result.add(v);
        }

        return result;
    }
}