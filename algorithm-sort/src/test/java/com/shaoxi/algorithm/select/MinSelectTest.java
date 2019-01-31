package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.sort.JdkSort;
import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class MinSelectTest extends SelectTestBase {

    @Test
    @DisplayName("查找最小只_10")
    void select(){
        int[] a = TestData.testData(10);
        int r = select(a, MinSelect::select, true);
        JdkSort.sort(a);
        int expect = a[0];
        Assertions.assertEquals(r, expect, "select result is incorrect!");
    }


}
