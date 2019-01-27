package com.shaoxi.algorithm.test.other;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * 递归测试
 *
 * @author shaoxi.ycw
 * @since 2019-01-27
 */
public class RecursionTest {
    @Test
    @DisplayName("递归测试")
    void recursion(){
        RecursionResult recursionResult = new RecursionResult();
        try{
            rec(0, recursionResult, new int[10000]);
        }catch (StackOverflowError e){
            System.out.println(String.format("run %s times", recursionResult.i));
            System.out.println(e);
        }
    }

    private void rec(int i, RecursionResult recursionResult, int... args){
        recursionResult.i = i;
        rec(i+1, recursionResult, args);
    }

    static class  RecursionResult{
        public int i;
    }
}
