package com.shaoxi.algorithm.subarray;

import com.shaoxi.algorithm.subarray.MaximumSubArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumSubArrayTest {
    @Test
    void divideFindMaximumSubArray(){
        //最大数字{1,3,-5,[2,-1,2,5,-2,3],-8} 3-8位
        int[] testArray = new int[]{1,3,-5,2,-1,2,5,-2,3,-8};
        MaximumSubArray.MaximumSubArrayResult result = MaximumSubArray.divideFindMaximumSubArray(testArray);
        System.out.println(result);
        Assertions.assertEquals(result.low, 3);
        Assertions.assertEquals(result.high, 8);
        Assertions.assertEquals(result.sum, 9);
    }

    @Test
    void linearFindMaximumSubArray(){
        //最大数字{1,3,-5,[2,-1,2,5,-2,3],-8} 3-8位
        int[] testArray = new int[]{1,3,-5,2,-1,2,5,-2,3,-8};
        MaximumSubArray.MaximumSubArrayResult result = MaximumSubArray.linearFindMaximumSubArray(testArray);
        System.out.println(result);
        Assertions.assertEquals(result.low, 3);
        Assertions.assertEquals(result.high, 8);
        Assertions.assertEquals(result.sum, 9);
    }
}
