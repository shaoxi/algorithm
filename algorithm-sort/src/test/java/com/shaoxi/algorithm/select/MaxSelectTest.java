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
public class MaxSelectTest extends SelectTestBase {

    @Test
    @DisplayName("查找最大值_10")
    void select(){
        int[] a = TestData.testData(100*10000);
        int r = select(a, MaxSelect::select, true);
        JdkSort.sort(a);
        int expect = a[a.length-1];
        Assertions.assertEquals(r, expect, "select result is incorrect!");
    }


}
