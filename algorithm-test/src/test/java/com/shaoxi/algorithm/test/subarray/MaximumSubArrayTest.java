package com.shaoxi.algorithm.test.subarray;

import com.shaoxi.algorithm.subarray.MaximumSubArray;
import org.junit.jupiter.api.Test;

public class MaximumSubArrayTest {
    @Test
    void findMaximumSubArray(){
        //最大数字[2,-1,2,5,-2,3]
        int[] testArray = new int[]{1,3,-5,2,-1,2,5,-2,3,-8};
        MaximumSubArray.MaximumSubArrayResult result = MaximumSubArray.findMaximumSubArray(testArray);

    }
}
