package com.shaoxi.algorithm.select;

import com.shaoxi.algorithm.sort.JdkSort;
import com.shaoxi.algorithm.test.tool.Printer;
import com.shaoxi.algorithm.test.tool.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shaoxi.ycw
 * @since 2019-01-31
 */
public class CommonSelectTest {
    @Test
    @DisplayName("查找第i小的数_i=1_size=100")
    void select() {
        int[] a = TestData.testData(100*10000);
        int i = a.length / 2;
        long start = System.currentTimeMillis();
        int result = CommonSelect.select(a, i);
        long useTime = System.currentTimeMillis() - start;
        JdkSort.sort(a);
        int expect = a[i-1];
        Printer.print("array", a);
        System.out.println("result\t" + result);
        System.out.println("expect\t" + expect);
        System.out.println("useTime\t" + useTime);
        Assertions.assertEquals(result, expect, "select result is incorrect!");
    }

}
