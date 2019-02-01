/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shaoxi.algorithm.datastructure;

import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author shaoxi.ycw
 * @version $Id: ArrayStackTest.java, v 0.1 2019年02月01日 9:11 AM shaoxi.ycw Exp $
 */
public class ArrayStackTest extends StackTestBase<Integer> {
    @Test
    @DisplayName("数组栈_size_100")
    void test() {
        List<Integer> testData = TestData.testDataSortedList(100);
        test(testData, new ArrayStack<>(), false);
    }
}