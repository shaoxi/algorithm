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
 * @version $Id: LinkedQueueTest.java, v 0.1 2019年02月01日 4:18 PM shaoxi.ycw Exp $
 */
public class LinkedQueueTest extends QueueTestBase<Integer> {
    @Test
    @DisplayName("LinkedQueue_无界队列_100_正常")
    void testNormal() {
        List<Integer> testData = TestData.testDataSortedList(100);
        test(testData, new LinkedQueue<>(), true);
    }

    @Test
    @DisplayName("LinkedQueue_无界队列_队列溢出_QueueUnderflowException")
    void testQueueUnderflowException() {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        Assertions.assertThrows(QueueUnderflowException.class, () -> {
            linkedQueue.enqueue(1);
            linkedQueue.dequeue();
            linkedQueue.dequeue();
        });
    }
}